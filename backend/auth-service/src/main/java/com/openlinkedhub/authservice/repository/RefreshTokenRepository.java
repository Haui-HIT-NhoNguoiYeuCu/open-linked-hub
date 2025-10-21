package com.openlinkedhub.authservice.repository;

import com.openlinkedhub.authservice.model.RefreshToken;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
    Optional<RefreshToken> findByToken(String token);
    void deleteByUserEmail(String userEmail);
}