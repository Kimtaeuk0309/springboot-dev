package me.taeuk.springbootdev.reposity;

import me.taeuk.springbootdev.domain.OAuthProvider;

public interface OAuthApiClient {

    OAuthProvider oAuthProvider();
    String requestAccessToken(OAuthLoginParams params);
    OAuthInfoResponse requestOauthInfo(String accessToken);
}
