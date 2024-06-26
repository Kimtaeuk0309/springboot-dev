package me.taeuk.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.taeuk.springbootdev.config.jwt.TokenProvider;
import me.taeuk.springbootdev.domain.User;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service

public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final UserService userService;

    public String createNewAccessToken(String refreshToken) {

        if(!tokenProvider.validToken(refreshToken)) {

            throw new IllegalArgumentException("Unexpected token");
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getUserId();
        User user = userService.findById(userId);

        return tokenProvider.generateToken(user, Duration.ofHours(2));
    }
}
