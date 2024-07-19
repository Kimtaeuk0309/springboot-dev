package me.taeuk.springbootdev.controller;

import lombok.RequiredArgsConstructor;
import me.taeuk.springbootdev.domain.AuthTokens;
import me.taeuk.springbootdev.service.KakaoLoginParam;
import me.taeuk.springbootdev.service.OAuthLoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")

public class AuthController {

    private final OAuthLoginService oAuthLoginService;

    @PostMapping("/kakao")
    public ResponseEntity<AuthTokens> loginKakao(@RequestBody KakaoLoginParam params) {

        return ResponseEntity.ok(oAuthLoginService.login(params));
    }
}
