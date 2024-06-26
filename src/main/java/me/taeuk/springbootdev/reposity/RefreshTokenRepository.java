package me.taeuk.springbootdev.reposity;

import me.taeuk.springbootdev.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByUserId(Long userID);
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
