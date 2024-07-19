package me.taeuk.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.taeuk.springbootdev.domain.AuthTokenGanerator;
import me.taeuk.springbootdev.domain.AuthTokens;
import me.taeuk.springbootdev.domain.Member;
import me.taeuk.springbootdev.reposity.MemberRepository;
import me.taeuk.springbootdev.reposity.OAuthInfoResponse;
import me.taeuk.springbootdev.reposity.OAuthLoginParams;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OAuthLoginService {

    private final MemberRepository memberRepository;
    private final AuthTokenGanerator authTokenGanerator;
    private final RequestOAuthInfoService requestOAuthInfoService;

    public AuthTokens login(OAuthLoginParams params) {

        OAuthInfoResponse oAuthInfoResponse = requestOAuthInfoService.request(params);
        Long memberId = findOrCreateMember(oAuthInfoResponse);
        return authTokenGanerator.generate(memberId);
    }

    public Long findOrCreateMember(OAuthInfoResponse oAuthInfoResponse) {

        return memberRepository.findByEmail(oAuthInfoResponse.getEmail())
                .map(Member::getId)
                .orElseGet(() -> newMember(oAuthInfoResponse));
    }

    public long newMember(OAuthInfoResponse oAuthInfoResponse) {

        Member member = Member.builder()
                .email(oAuthInfoResponse.getEmail())
                .nickname(oAuthInfoResponse.getNickname())
                .oAuthProvider(oAuthInfoResponse.getOAuthProvider())
                .build();

        return memberRepository.save(member).getId();
    }
}
