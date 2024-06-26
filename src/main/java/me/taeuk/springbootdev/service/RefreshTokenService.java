package me.taeuk.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.taeuk.springbootdev.domain.RefreshToken;
import me.taeuk.springbootdev.reposity.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {

        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
