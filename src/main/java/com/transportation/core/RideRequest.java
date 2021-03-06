package com.transportation.core;

import com.transportation.application.Event;
import com.transportation.application.Offer;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

public class RideRequest {
    private boolean start, end;
    private String date;
    private int noOfPass;
    private ArrayList<Offer> offers = new ArrayList<>();
    private ArrayList<Event> events = new ArrayList<>();

    public RideRequest() {
    }

    public void setNoOfPass(int noOfPass) {
        this.noOfPass = noOfPass;
    }

    public int getNoOfPass() {
        return noOfPass;
    }

    public boolean addOffer(Offer newOffer) {
        return offers.add(newOffer);
    }

    public ArrayList<Offer> getOffers() {
        return offers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        LocalDate date1 = LocalDate.now();
        this.date = date1.toString();
    }

    public boolean addEvent(Event event) { return events.add(event); }

    public boolean removeEvent(Event event) {
        return events.remove(event);
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "RideRequest{" +
                "noOfPass=" + noOfPass +
                ", offers=" + offers.toString() +
                ", events=" + events.toString() +
                '}';
    }

    public boolean getEnd() {
        return end;
    }

}