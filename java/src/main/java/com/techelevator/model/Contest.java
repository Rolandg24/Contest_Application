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
    private String contestImageUrl;

    // constructors
    public Contest(int contestId, String contestName, String contestDescription, String dateAndTime, String contestLocation, String contestCategoryName, String contestImageUrl) {
        this.contestId = contestId;
        this.contestName = contestName;
        this.contestDescription = contestDescription;
        this.dateAndTime = dateAndTime;
        this.contestLocation = contestLocation;
        this.contestCategoryName = contestCategoryName;
        this.contestImageUrl = contestImageUrl;
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

    public String getContestImageUrl() {
        return contestImageUrl;
    }

    public void setContestImageUrl(String contestImageUrl) {
        this.contestImageUrl = contestImageUrl;
    }
}
