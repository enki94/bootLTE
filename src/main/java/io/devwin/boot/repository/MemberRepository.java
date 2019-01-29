package io.devwin.boot.repository;

import io.devwin.boot.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByEmail(String email);
}
