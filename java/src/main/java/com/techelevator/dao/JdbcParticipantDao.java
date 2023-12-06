package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.OverallScore;
import com.techelevator.model.Participant;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcParticipantDao implements ParticipantDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcParticipantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Participant> fetchListOfParticipantByContestId(int contestId) {
        List<Participant> participants = new ArrayList<>();

        String sql = "SELECT participant_id, participant_name, participant_description, member_count, score, contest_id " +
                     "FROM participants " +
                     "WHERE contest_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contestId);
            while (results.next()) {
                Participant tempParticipant = mapRowToParticipant(results);
                participants.add(tempParticipant);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return participants;
    }

    @Override
    public List<OverallScore> fetchListOfOverallScores(int contestId) {
        List<OverallScore> overallScores = new ArrayList<>();
        String sql = "SELECT overall_scores.overall_score_id, overall_scores.contest_id, overall_scores.participant_id, overall_scores.overall_score, participant.participant_name " +
                        "FROM overall_scores " +
                        "JOIN participants ON participants.participant_id = overall_scores.participant_id" +
                        "WHERE contest_id = ?;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contestId);
            while (results.next()) {
                OverallScore tempScore = mapRowToScore(results);
                overallScores.add(tempScore);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return overallScores;
    }

    private Participant mapRowToParticipant(SqlRowSet rowSet) {
        Participant participant = new Participant();
        participant.setParticipantId(rowSet.getInt("participant_id"));
        participant.setParticipantName(rowSet.getString("participant_name"));
        participant.setParticipantDescription(rowSet.getString("participant_description"));
        participant.setMemberCount(rowSet.getInt("member_count"));
        participant.setScore(rowSet.getDouble("score"));
        participant.setContestId(rowSet.getInt("contest_id"));
        return participant;
    }

    private OverallScore mapRowToScore(SqlRowSet rowSet) {
        OverallScore score = new OverallScore();
        score.setOverallScoreId(rowSet.getInt("overall_score_id"));
        score.setContestId(rowSet.getInt("contest_id"));
        score.setParticipantId(rowSet.getInt("participant_id"));
        score.setOverallScore(rowSet.getInt("overall_score"));
        score.setParticipantName(rowSet.getInt("participant_name"));
        return score;
    }
}
