package com.events.EventsProject.controller;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.PagesResponse;
import com.events.EventsProject.cms.model.Event;
import com.events.EventsProject.model.dto.ReviewDTO;
import com.events.EventsProject.service.ReviewService;
import com.events.EventsProject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private IButterCMSClient butterCMSClient;
    private UserService userService;
    private ReviewService reviewService;

    public HomeController(IButterCMSClient butterCMSClient, UserService userService, ReviewService reviewService) {
        this.butterCMSClient = butterCMSClient;
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @GetMapping("/")
    public String viewIndex(Model model) {
        PagesResponse<Event> events = butterCMSClient.getPages("event", null, Event.class);
        model.addAttribute("events", events.getData());
        if (userService.getCurrentUser().isPresent()) {
            model.addAttribute("fullName", userService.getCurrentUser().get().getFirstName() + " " + userService.getCurrentUser().get().getLastName());
        }
        return "index";
    }

    @GetMapping("/reviews")
    public String viewReviews(Model model) {
        model.addAttribute("reviewDTO", new ReviewDTO());
        return "reviews";
    }

    @PostMapping("/reviews")
    public String postReview(@Valid @ModelAttribute ReviewDTO reviewDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reviews";
        }
        reviewService.save(reviewDTO);
        return "redirect:/reviews";
    }
}
