package com.openlinkedhub.authservice.service.impl;

import com.openlinkedhub.authservice.config.JwtService;
import com.openlinkedhub.authservice.dto.request.LoginRequest;
import com.openlinkedhub.authservice.dto.request.RefreshTokenRequest;
import com.openlinkedhub.authservice.dto.request.RegisterRequest;
import com.openlinkedhub.authservice.dto.response.AuthResponse;
import com.openlinkedhub.authservice.model.RefreshToken;
import com.openlinkedhub.authservice.model.Role;
import com.openlinkedhub.authservice.model.User;
import com.openlinkedhub.authservice.repository.RefreshTokenRepository;
import com.openlinkedhub.authservice.repository.UserRepository;
import com.openlinkedhub.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        // 409 nếu email đã tồn tại
        final String email = safeEmail(request.getEmail());
        if (userRepository.existsByEmail(email)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }

        // chuẩn hoá & kiểm tra role (400 nếu sai)
        Role role = parseRoleOrBadRequest(request.getRole());

        var user = User.builder()
                .email(email)
                .password(passwordEncoder.encode(request.getPassword()))
                .role(role)
                .build();
        userRepository.save(user);

        // phát hành token (tuỳ flow của bạn)
        var accessToken  = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        // Revoke cũ theo userEmail rồi lưu token mới
        revokeAndSaveRefreshToken(user, refreshToken);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    @Transactional
    public AuthResponse login(LoginRequest request) {
        final String email = safeEmail(request.getEmail());

        // ném 401 nếu credential sai
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, request.getPassword())
            );
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid email or password");
        }

        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));

        var accessToken  = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        revokeAndSaveRefreshToken(user, refreshToken);

        return AuthResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    @Transactional
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        var dbToken = refreshTokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid refresh token"));

        var user = userRepository.findByEmail(dbToken.getUserEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found"));

        var newAccessToken  = jwtService.generateAccessToken(user);
        var newRefreshToken = jwtService.generateRefreshToken(user);

        revokeAndSaveRefreshToken(user, newRefreshToken);

        return AuthResponse.builder()
                .accessToken(newAccessToken)
                .refreshToken(newRefreshToken)
                .build();
    }

    @Override
    @Transactional
    public void logout(RefreshTokenRequest request) {
        // Mặc định: xoá đúng refresh token được gửi lên
        refreshTokenRepository.findByToken(request.getToken())
                .ifPresent(refreshTokenRepository::delete);

        // Nếu muốn "logout tất cả phiên" của user, thay bằng:
        // refreshTokenRepository.findByToken(request.getToken())
        //     .ifPresent(t -> refreshTokenRepository.deleteByUserEmail(t.getUserEmail()));
    }

    // ====== Helpers (không @Transactional) ======

    private void saveRefreshToken(User user, String refreshTokenString) {
        var token = RefreshToken.builder()
                .userEmail(user.getEmail())
                .token(refreshTokenString)
                .build();
        refreshTokenRepository.save(token);
    }

    private void revokeAndSaveRefreshToken(User user, String refreshTokenString) {
        // Xoá tất cả refresh token cũ của user trước khi lưu
        refreshTokenRepository.deleteByUserEmail(user.getEmail());
        saveRefreshToken(user, refreshTokenString);
    }

    private Role parseRoleOrBadRequest(String roleInput) {
        if (roleInput == null || roleInput.isBlank()) return Role.USER; // default
        try {
            return Role.valueOf(roleInput.trim().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid role: " + roleInput);
        }
    }

    private String safeEmail(String email) {
        if (email == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email must not be null");
        }
        return email.trim().toLowerCase();
    }
}
