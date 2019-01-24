package io.devwin.boot;

import io.devwin.boot.model.Member;
import io.devwin.boot.model.MemberRole;
import io.devwin.boot.repository.MemberRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 계정만들기() {
        for(int i=0; i<100; i++) {
            Member member = new Member();
            member.setUid("user" + i);
            member.setUpw("pw" + i);
            member.setUemail("hihi@" + i);
            MemberRole role = new MemberRole();
            if(i <= 80) {
                role.setRoleName("BASIC");
            }else if(i <= 90) {
                role.setRoleName("MANAGER");
            }else {
                role.setRoleName("ADMIN");
            }
            member.setRoles(Arrays.asList(role));
            memberRepository.save(member);
        }
    }

    @Test
    public void 계정테스트() {
        Optional<Member> result = Optional.of(memberRepository.findById(85L).get());
        result.ifPresent(member -> log.info("member " + member));
    }
}