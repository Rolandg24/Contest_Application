package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Contest;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcContestDao implements ContestDao{

    private final JdbcTemplate jdbcTemplate;
    private final int NOT_UPDATED = 0;
    private final int UPDATED = 1;

    public JdbcContestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contest> fetchListOfContests() {
        List<Contest> contestList = new ArrayList<>();
        String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location FROM contests";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                Contest tempContest = mapRowToContest(results);
                contestList.add(tempContest);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return contestList;
    }
    @Override
    public Contest createContest(Contest contest) {
        Contest contestToCreate = contest;
        String sql = "INSERT INTO contests (contest_name, contest_description, contest_date_time, contest_location)\n" +
                "VALUES (?, ?, ?, ?) RETURNING contest_id;";

        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, contest.getContestName(), contest.getContestDescription(), contest.getDateAndTime(), contest.getContestLocation());
            if (result.next()) {
                contestToCreate.setContestId(result.getInt("contest_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return contestToCreate;

    }

    @Override
    public Contest updateContest(Contest contest) {
        String sql = "UPDATE contests SET contest_name = ?, contest_description = ?, contest_date_time = ?, contest_location = ?" +
                "WHERE contest_id = ?";
        int rowCount = NOT_UPDATED;
        try {
        rowCount = jdbcTemplate.update(sql, contest.getContestName(), contest.getContestDescription(), contest.getDateAndTime(),
                contest.getContestLocation(), contest.getContestId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }

        if (rowCount < UPDATED) {
            throw new DaoException("Error. Contest was not updated");
        }

        return contest;
    }

    @Override
    public boolean deleteContest(int contestId) {
        String sqlDeleteParticipants = "DELETE FROM participants WHERE contest_id = ?;";
        String sqlDeleteContest = "DELETE FROM contests WHERE contest_id = ?";
        int rowCountParticipants = 0;
        int rowCountContests = 0;
        boolean isDeleted = false;
        try {
            rowCountParticipants = jdbcTemplate.update(sqlDeleteParticipants, contestId);
            rowCountContests = jdbcTemplate.update(sqlDeleteContest,contestId);
            if (rowCountParticipants > 0 && rowCountContests > 0) {
                isDeleted = true;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }

        if (!isDeleted) {
            throw new DaoException("Error. Contest was not deleted");
        }

        return isDeleted;
    }

    private Contest mapRowToContest(SqlRowSet rowSet) {
        Contest contest = new Contest();
        contest.setContestId(rowSet.getInt("contest_id"));
        contest.setContestName(rowSet.getString("contest_name"));
        contest.setContestDescription(rowSet.getString("contest_description"));
        contest.setDateAndTime(rowSet.getDate("contest_date_time").toLocalDate());
        contest.setContestLocation(rowSet.getString("contest_location"));
        return contest;
    }


}
