package com.techelevator.model;

import java.time.LocalDate;

//variables
public class ScheduleTimeSlot {
    private int timeSlotId;
    private int contestId;
    private int participantId;
    private String timeSlot;
    private String participantName;


    //constructors


    public ScheduleTimeSlot(int timeSlotId, int contestId, int participantId, String timeSlot, String participantName) {
        this.timeSlotId = timeSlotId;
        this.contestId = contestId;
        this.participantId = participantId;
        this.timeSlot = timeSlot;
        this.participantName = participantName;
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

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }
}
