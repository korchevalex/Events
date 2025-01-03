package com.events.EventsProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    @GetMapping("/events")
    public String viewEvents() {
        return "event";
    }
}
