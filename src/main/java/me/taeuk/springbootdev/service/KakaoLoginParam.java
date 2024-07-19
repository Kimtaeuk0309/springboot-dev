package me.taeuk.springbootdev.service;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.taeuk.springbootdev.domain.OAuthProvider;
import me.taeuk.springbootdev.reposity.OAuthLoginParams;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Getter
@NoArgsConstructor

public class KakaoLoginParam implements OAuthLoginParams {

    private String authorizationCode;

    @Override
    public OAuthProvider oAuthProvider() {

        return OAuthProvider.KAKAO;
    }

    @Override
    public MultiValueMap<String, String> makeBody() {

        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("code", authorizationCode);
        return body;
    }
}
