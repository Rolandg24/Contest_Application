package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Contest;
import com.techelevator.model.OverallScore;
import com.techelevator.model.Participant;
import org.springframework.dao.DataIntegrityViolationException;
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
    public Participant createNewParticipant(Participant participant) {
        Participant participantToCreate = participant;
        String sql = "INSERT INTO participants (participant_name, participant_description, member_count, score, contest_id) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "RETURNING participant_id";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, participantToCreate.getParticipantName(), participantToCreate.getParticipantDescription(),
                    participantToCreate.getMemberCount(), participantToCreate.getScore(), participantToCreate.getContestId());
            if (result.next()) {
                participantToCreate.setParticipantId(result.getInt("participant_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return participantToCreate;
    }

    @Override
    public Participant updateParticipant(Participant participant) {
        String sql = "UPDATE participants " +
                "SET participant_name = ?, participant_description = ?, member_count = ?, score = ?, contest_id = ?" +
                "WHERE participant_id = ?";
        int rowCount = 0;
        try {
            rowCount = jdbcTemplate.update(sql, participant.getParticipantName(), participant.getParticipantDescription(),
                    participant.getMemberCount(), participant.getScore(), participant.getContestId(), participant.getParticipantId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        if (rowCount < 1) {
            throw new DaoException("Error. Contest was not updated");
        }
        return participant;
    }

    @Override
    public int deleteParticipant(int participantId) {

        String sql = "START TRANSACTION; " +
                "DELETE FROM time_slots WHERE participant_id = ?; " +
                "DELETE FROM participants WHERE participant_id = ?; " +
                "COMMIT;";

        try {
            return jdbcTemplate.update(sql, participantId, participantId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error deleting contest" + participantId, e);
        }
    }

    @Override
    public Participant fetchParticipantById(int participantId) {
        Participant participant = null;

        String sql = "SELECT participant_id, participant_name, participant_description, member_count, score, contest_id " +
                "FROM participants " +
                "WHERE participant_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, participantId);
            if (results.next()) {
                participant = mapRowToParticipant(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return participant;
    }

    @Override
    public List<OverallScore> fetchListOfOverallScores(int contestId) {
        List<OverallScore> overallScores = new ArrayList<>();
        String sql = "SELECT overall_scores.overall_score_id, overall_scores.contest_id, overall_scores.participant_id, " +
                "overall_scores.overall_score, participants.participant_name " +
                "FROM overall_scores " +
                "JOIN participants ON participants.participant_id = overall_scores.participant_id " +
                "WHERE overall_scores.contest_id = ? " +
                "ORDER BY overall_score DESC";

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

    @Override
    public OverallScore createOverallScore(OverallScore overallScore) {
        OverallScore overallScoreToCreate = overallScore;
        String sql = "INSERT INTO overall_scores (contest_id, participant_id, overall_score)" +
                "VALUES (?, ?, ?) " +
                "RETURNING overall_score_id;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, overallScoreToCreate.getContestId(), overallScoreToCreate.getParticipantId(),
                    overallScoreToCreate.getOverallScore());
            if (result.next()) {
                overallScoreToCreate.setOverallScoreId(result.getInt("overall_score_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return overallScoreToCreate;
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
        score.setParticipantName(rowSet.getString("participant_name"));
        return score;
    }
}
