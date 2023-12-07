package com.techelevator.model;

import java.time.LocalDate;

public class Contest {
    // variables
    private int contestId;
    private String contestName;
    private String contestDescription;
    private String dateAndTime;
    private String contestLocation;
    private String contestCategoryName;

    // constructors
    public Contest(int contestId, String contestName, String contestDescription, String dateAndTime, String contestLocation, String contestCategoryName) {
        this.contestId = contestId;
        this.contestName = contestName;
        this.contestDescription = contestDescription;
        this.dateAndTime = dateAndTime;
        this.contestLocation = contestLocation;
        this.contestCategoryName = contestCategoryName;
    }

    public Contest (){

    }

    //methods

    // getters and setters
    public int getContestId() {
        return contestId;
    }

    public void setContestId(int contestId) {
        this.contestId = contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public void setContestName(String contestName) {
        this.contestName = contestName;
    }

    public String getContestDescription() {
        return contestDescription;
    }

    public void setContestDescription(String contestDescription) {
        this.contestDescription = contestDescription;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getContestLocation() {
        return contestLocation;
    }

    public void setContestLocation(String contestLocation) {
        this.contestLocation = contestLocation;
    }

    public String getContestCategoryName() {
        return contestCategoryName;
    }

    public void setContestCategoryName(String contestCategoryName) {
        this.contestCategoryName = contestCategoryName;
    }
}
