package com.events.EventsProject.controller;

import com.events.EventsProject.cms.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PageResponse;
import com.buttercms.model.PagesResponse;

import java.time.LocalDateTime;


@Controller
public class PageController {
    private IButterCMSClient butterCMSClient;

    public PageController(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    @GetMapping("/events/{slug}")
    public String getEventPage(Model model, @PathVariable("slug") String slug) {
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

    @GetMapping("/events/upcoming")
    public String getUpcomingEvents(Model model) {
        PagesResponse<Event> events = butterCMSClient.getPages("event", null, Event.class);
        events.setData(events.getData().stream().filter(e -> e.getFields().getDate().isAfter(LocalDateTime.now())).toList());
        model.addAttribute("events", events.getData());
        return "all-events";
    }

    @GetMapping("/clubs")
    public String getClubs(Model model) {
        PagesResponse<Event> clubs = butterCMSClient.getPages("club", null, Event.class);
        model.addAttribute("clubs", clubs.getData());
        return "clubs";
    }

    @GetMapping("/clubs/{slug}")
    public String getClubPage(Model model, @PathVariable("slug") String slug) {
        PageResponse<Event> page = butterCMSClient.getPage("club", slug, null, Event.class);
        model.addAttribute("page", page.getData().getFields());
        return "club";
    }
}
