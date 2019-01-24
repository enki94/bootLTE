package io.devwin.boot.repository;

import io.devwin.boot.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Page<Person> findByFilter(@Param("keyword") String keyword, Pageable pageable);
    findByUemail();
}
