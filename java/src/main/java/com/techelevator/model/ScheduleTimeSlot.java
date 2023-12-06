package com.techelevator.model;

import java.time.LocalDate;

//variables
public class ScheduleTimeSlot {
    private int timeSlotId;
    private int contestId;
    private int participantId;
    private String timeSlot;


    //constructors


    public ScheduleTimeSlot(int timeSlotId, int contestId, int participantId, String timeSlot) {
        this.timeSlotId = timeSlotId;
        this.contestId = contestId;
        this.participantId = participantId;
        this.timeSlot = timeSlot;
    }

    public ScheduleTimeSlot(){

    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }
}
