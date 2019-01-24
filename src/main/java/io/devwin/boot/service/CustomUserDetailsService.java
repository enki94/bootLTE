package io.devwin.boot.service;

import io.devwin.boot.model.SecurityMember;
import io.devwin.boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return Optional.ofNullable(memberRepository.findByUemail(email))
                .filter(m -> m!= null)
                .map(m -> new SecurityMember(m)).get();
    }
}