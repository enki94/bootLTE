package io.devwin.boot.controller;

import io.devwin.boot.model.Person;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class restController {

    @PostMapping("/persons/")
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/results";
    }

    //@PutMapping("/person/{id}")
}
