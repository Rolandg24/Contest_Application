package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.OverallScore;
import com.techelevator.model.Participant;

import javax.servlet.http.Part;
import java.util.List;

public interface ParticipantDao {
    public List<Participant> fetchListOfParticipantByContestId(int contestId);

    public List<OverallScore> fetchListOfOverallScores(int contestId);
    public OverallScore createOverallScore(OverallScore overallScore);

    public Participant createNewParticipant(Participant participant);

    public Participant updateParticipant(Participant participant);

    public int deleteParticipant(int ParticipantId);
}
