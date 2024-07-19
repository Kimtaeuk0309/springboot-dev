package me.taeuk.springbootdev.reposity;

import me.taeuk.springbootdev.domain.OAuthProvider;

public interface OAuthInfoResponse {

    String getEmail();
    String getNickname();
    OAuthProvider getOAuthProvider();
}
