package com.techelevator.dao;

import com.techelevator.model.Contest;

import java.util.List;

public interface ContestDao {

    public List<Contest> fetchListOfContests();

    public Contest createContest(Contest contest);

    public Contest updateContest(Contest contest);

    public int deleteContest(int contestId);


}
