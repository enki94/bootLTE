package io.devwin.bootLTE.repository;

import io.devwin.bootLTE.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByEmail(String email);
}
