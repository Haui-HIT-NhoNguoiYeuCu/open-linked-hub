package com.openlinkedhub.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@RedisHash("refresh_tokens")
public class RefreshToken {
    @Id private String id;
    @Indexed private String token;
    private String userEmail;
}
