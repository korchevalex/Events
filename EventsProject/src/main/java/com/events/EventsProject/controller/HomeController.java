package com.events.EventsProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String viewIndex() {
        return "index";
    }

    @GetMapping("/generic")
    public String viewGeneric() {
        return "generic";
    }

    @GetMapping("/elements")
    public String viewElements() {
        return "elements";
    }
}
