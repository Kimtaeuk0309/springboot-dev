package me.taeuk.springbootdev.service;

import lombok.RequiredArgsConstructor;
import me.taeuk.springbootdev.domain.User;
import me.taeuk.springbootdev.reposity.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}