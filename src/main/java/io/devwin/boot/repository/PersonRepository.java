package io.devwin.boot.repository;

import io.devwin.boot.model.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {
    @Query("select p from Person p where first_name like concat('%',:keyword,'%') or last_name like concat('%',:keyword,'%')")
    Page<Person> findByFilter(@Param("keyword") String keyword, Pageable pageable);
}
