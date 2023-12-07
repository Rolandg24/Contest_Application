package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.OverallScore;
import com.techelevator.model.Participant;

import java.util.List;

public interface ParticipantDao {
    public List<Participant> fetchListOfParticipantByContestId(int contestId);

    public List<OverallScore> fetchListOfOverallScores(int contestId);
    public OverallScore createOverallScore(OverallScore overallScore);

}
