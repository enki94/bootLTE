package io.devwin.boot.controller;

import io.devwin.boot.model.Member;
import io.devwin.boot.model.MemberRole;
import io.devwin.boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @PostMapping("")
    public String create(Member member) {
        MemberRole role = new MemberRole();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setUpw(passwordEncoder.encode(member.getUpw()));
        role.setRoleName("BASIC");
        member.setRoles(Arrays.asList(role));
        memberRepository.save(member);
        return "redirect:/";
    }
}