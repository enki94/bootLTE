package io.devwin.bootLTE.rest;

import io.devwin.bootLTE.model.Person;
import io.devwin.bootLTE.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api2/persons")
public class personRestController {

    @Autowired
    PersonRepository personRepository;

    @PostMapping("/")
    public Map<String, Object> insert(@Valid Person person, BindingResult bindingResult) {
        return save(person, bindingResult);
    }

    @PutMapping("/{id}")
    public Map<String, Object> update(@Valid Person person, BindingResult bindingResult) {
        return save(person, bindingResult);
    }

    public Map<String, Object> save(@Valid Person person, BindingResult bindingResult) {
        Map<String, Object> map = new HashMap<>();
        List errList = new ArrayList();

        if(bindingResult.hasErrors()) {
            List<FieldError> list = bindingResult.getFieldErrors();
            for(FieldError err:list) {
                Map<String, Object> mapErr = new HashMap<>();
                mapErr.put("field",err.getField());
                mapErr.put("message",err.getDefaultMessage());
                errList.add(mapErr);
            }

            map.put("status", "ERROR");
            map.put("error", errList);
        } else {
            personRepository.save(person);
            map.put("status", "OK");
        }
        return map;
    }

}