package com.techelevator.model;

import java.time.LocalDate;

public class Participant {

    //variables
    private int participantId;
    private String participantName;
    private String participantDescription;
    private int memberCount;
    private double score;
    private int contestId;
    private String participantImageUrl;
    private int votes;
    //constructors


    public Participant(int participantId, String participantName, String participantDescription, int numberCount, double score, int contestId, String participantImageUrl) {
        this.participantId = participantId;
        this.participantName = participantName;
        this.participantDescription = participantDescription;
        this.memberCount = numberCount;
        this.score = score;
        this.contestId = contestId;
        this.participantImageUrl = participantImageUrl;
        this.votes = 0;
    }
    //default
    public Participant(){

    }
    //getter/setters

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantDescription() {
        return participantDescription;
    }

    public void setParticipantDescription(String participantDescription) {
        this.participantDescription = participantDescription;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getParticipantImageUrl() {
        return participantImageUrl;
    }

    public void setParticipantImageUrl(String participantImageUrl) {
        this.participantImageUrl = participantImageUrl;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
