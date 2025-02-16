package com.events.EventsProject.cms.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class Event {
    private String title;
    private LocalDateTime date;
    private String organiser;
    private String participants;
    private String address;
    private String image;
    private String text;
    private String shortText;

    public void setDate(String date) {
        this.date = LocalDateTime.parse(date);
    }

    public String getFormattedDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
}
