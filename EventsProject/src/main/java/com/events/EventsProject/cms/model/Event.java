package com.events.EventsProject.cms.model;

import java.awt.*;
import java.time.LocalDateTime;

public class Event {
    private String title;
    private String date;
    private String organiser;
    private String guest;
    private String address;
    private String image;
    private String text;
    private String shortText;

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getOrganiser() {
        return organiser;
    }

    public String getGuest() {
        return guest;
    }

    public String getAddress() {
        return address;
    }

    public String getImage() {
        return image;
    }

    public String getText() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date.replace("T", " ").substring(0, date.length() - 3);
    }

    public void setOrganiser(String organiser) {
        this.organiser = organiser;
    }

    public void setGuest(String guest) {
        this.guest = guest;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }
}
