package com.events.EventsProject.controller;

import com.events.EventsProject.cms.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PageResponse;
import com.buttercms.model.PagesResponse;


@Controller
public class PageController {
    private IButterCMSClient butterCMSClient;

    public PageController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/event/{slug}")
    public String getPage(Model model, @PathVariable("slug") String slug) {
        PageResponse<Event> page = butterCMSClient.getPage("event", slug, null, Event.class);
        model.addAttribute("page", page.getData().getFields());
        return "event";
    }

    @GetMapping("/events")
    public String getEvents(Model model) {
        PagesResponse<Event> events = butterCMSClient.getPages("event", null, Event.class);
        model.addAttribute("events", events.getData());
        return "all-events";
    }
}
