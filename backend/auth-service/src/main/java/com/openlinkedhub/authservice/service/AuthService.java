package com.openlinkedhub.authservice.service;

import com.openlinkedhub.authservice.dto.response.AuthResponse;
import com.openlinkedhub.authservice.dto.request.LoginRequest;
import com.openlinkedhub.authservice.dto.request.RefreshTokenRequest;
import com.openlinkedhub.authservice.dto.request.RegisterRequest;

public interface AuthService {

    /**
     * Đăng ký một người dùng mới.
     * @param request thông tin đăng ký
     * @return AuthResponse chứa access token và refresh token
     */
    AuthResponse register(RegisterRequest request);

    /**
     * Đăng nhập cho người dùng đã tồn tại.
     * @param request thông tin đăng nhập
     * @return AuthResponse chứa access token và refresh token mới
     */
    AuthResponse login(LoginRequest request);

    /**
     * Làm mới access token bằng refresh token.
     * @param request chứa refresh token
     * @return AuthResponse chứa access token và refresh token mới
     */
    AuthResponse refreshToken(RefreshTokenRequest request);

    /**
     * Đăng xuất, vô hiệu hóa refresh token.
     * @param request chứa refresh token
     */
    void logout(RefreshTokenRequest request);
}