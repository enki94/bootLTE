package io.devwin.boot.rest;

import io.devwin.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api2/persons")
public class personRestController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/findByFilter")
    public Map<String, Object> list(@Param(value="keyword") String keyword, Pageable pageable) {
        //Pageable pageable = null;
        //pageable.

        personRepository.findByFilter(keyword, pageable);

        Map<String, Object> retMap = new HashMap<>();
        return retMap;
    }

}
