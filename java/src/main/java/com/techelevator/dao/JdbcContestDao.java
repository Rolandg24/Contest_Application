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
