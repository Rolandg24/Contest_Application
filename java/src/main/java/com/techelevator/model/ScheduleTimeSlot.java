package com.techelevator.model;

import java.time.LocalDate;

//variables
public class ScheduleTimeSlot {
    private String name;
    private String timeSlot;
    private int contestId;

    //constructors
    public ScheduleTimeSlot(String name, String timeSlot, int contestId) {
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

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
