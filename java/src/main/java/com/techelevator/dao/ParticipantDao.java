package com.techelevator.dao;

import com.techelevator.model.Participant;

import java.util.List;

public interface ParticipantDao {
    public List<Participant> fetchListOfParticipantByContestId(int contestId);
}
