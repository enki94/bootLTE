package io.devwin.boot.rest;

import io.devwin.boot.model.Datatable;
import io.devwin.boot.model.Person;
import io.devwin.boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api2/persons")
public class personRestController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/findByFilter")
    public Page<Person> list(HttpServletRequest request) {
        //Pageable pageable = null;
        //pageable.
        //Map<String, Object> retMap = new HashMap<>();

        //System.out.println(datatable.getDraw());
        //System.out.println(datatable.getColumns()[0]["data"]);
        String[] param = request.getParameterValues("columns");
        System.out.println(param.toString());

        //Page<Person> retMap = personRepository.findByFilter(keyword, pageable);
        Page<Person> retMap = null;

        return retMap;
    }

}
