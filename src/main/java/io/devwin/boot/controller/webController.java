package io.devwin.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class webController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    @RequestMapping("/data.html")
    public String datatable() {
        return "datatable";
    }

    @RequestMapping("/data2.html")
    public String datatable2() {
        return "datatable2";
    }

    @RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value = "name", defaultValue = "Unknown", required = false) String name) {
        String greetings = "Hello, " + name + "!";
        model.addAttribute("greetings", greetings);
        return "hello";
    }
}
