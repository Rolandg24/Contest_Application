package com.techelevator.model;

import java.time.LocalDate;

//variables
public class ScheduleTimeSlot {
    private String name;
    private LocalDate timeSlot;
    private int contestId;

    //constructors
    public ScheduleTimeSlot(String name, LocalDate timeSlot, int contestId) {
        this.name = name;
        this.timeSlot = timeSlot;
        this.contestId = contestId;
    }

    public ScheduleTimeSlot (){

    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(LocalDate timeSlot) {
        this.timeSlot = timeSlot;
    }
}
