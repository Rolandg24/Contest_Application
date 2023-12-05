package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.ScheduleTimeSlot;

import java.util.List;

public interface ContestDao {


    //CRUD contest
    public List<Contest> fetchListOfContests();

    public Contest createContest(Contest contest);

    public Contest updateContest(Contest contest);

    public int deleteContest(int contestId);

    public Contest fetchContestById(int id);


    //schedule
    public List<ScheduleTimeSlot> fetchScheduleById(int contestId);




}
