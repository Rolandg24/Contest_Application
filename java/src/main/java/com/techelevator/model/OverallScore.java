package com.techelevator.model;

public class OverallScore {

    private int overallScoreId;
    private int contestId;
    private int participantId;
    private int overallScore;
    private int participantName;

    public OverallScore(int overallScoreId, int contestId, int participantId, int overallScore, int participantName) {
        this.overallScoreId = overallScoreId;
        this.contestId = contestId;
        this.participantId = participantId;
        this.overallScore = overallScore;
        this.participantName = participantName;
    }


    public OverallScore() {

    }

    public int getOverallScoreId() {
        return overallScoreId;
    }

    public void setOverallScoreId(int overallScoreId) {
        this.overallScoreId = overallScoreId;
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

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }

    public int getParticipantName() {
        return participantName;
    }

    public void setParticipantName(int participantName) {
        this.participantName = participantName;
    }
}
