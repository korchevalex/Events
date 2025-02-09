package com.events.EventsProject.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PagesResponse;
import com.events.EventsProject.cms.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private IButterCMSClient butterCMSClient;

    public HomeController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        PagesResponse<Event> events = butterCMSClient.getPages("event", null, Event.class);
        model.addAttribute("events", events.getData());
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
