package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Contest;
import com.techelevator.model.ScheduleTimeSlot;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcContestDao implements ContestDao {

    private final JdbcTemplate jdbcTemplate;
    private final int NOT_UPDATED = 0;
    private final int UPDATED = 1;

    public JdbcContestDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contest> fetchListOfContests() {
        List<Contest> contestList = new ArrayList<>();
        String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location " +
                "FROM contests";
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
    public Contest fetchContestById(int id) {
        Contest contest = null;

        String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location " +
                "FROM contests " +
                "WHERE contest_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                contest = mapRowToContest(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return contest;
    }


    @Override
    public Contest createContest(Contest contest) {
        Contest contestToCreate = contest;
        String sql = "INSERT INTO contests (contest_name, contest_description, contest_date_time, contest_location)" +
                "VALUES (?, ?, ?, ?) " +
                "RETURNING contest_id;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, contest.getContestName(), contest.getContestDescription(),
                    contest.getDateAndTime(), contest.getContestLocation());
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
        String sql = "UPDATE contests " +
                "SET contest_name = ?, contest_description = ?, contest_date_time = ?, contest_location = ?" +
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


    //TODO clean up
    @Override
    public int deleteContest(int contestId) {

        String sql = "START TRANSACTION; " +
                "DELETE FROM participants WHERE contest_id = ?; " +
                "DELETE FROM contests WHERE contest_id = ?; " +
                "COMMIT;";

//        String sqlDeleteParticipants = "DELETE FROM participants WHERE contest_id = ?;";
//        String sqlDeleteContest = "DELETE FROM contests WHERE contest_id = ?";
//        int rowCountParticipants = 0;
//        int rowCountContests = 0;
//        int rowCount = 0;
//        boolean isDeleted = false;
        try {
//            rowCountParticipants = jdbcTemplate.update(sqlDeleteParticipants, contestId);
//            rowCountContests = jdbcTemplate.update(sqlDeleteContest,contestId);
            return jdbcTemplate.update(sql, contestId, contestId);
//            if (rowCount > 0) {
//                isDeleted = true;
//            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);

        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Error deleting contest" + contestId, e);
        }
//        if (isDeleted == false) {
//            throw new DaoException("Error. Contest was not deleted");
//        }
//        return isDeleted;
    }


    @Override
    public List<ScheduleTimeSlot> fetchScheduleById(int contestId) {
        List<ScheduleTimeSlot> schedule = new ArrayList<>();

        String sql = "SELECT participants.participant_name, schedules.contest_id, schedules_participants.time_slot " +
                "FROM participants " +
                "JOIN schedules_participants ON participants.participant_id = schedules_participants.participant_id " +
                "JOIN schedules ON schedules_participants.schedule_id = schedules.schedule_id " +
                "WHERE schedules.contest_id = ?";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contestId);
            while (results.next()) {
                ScheduleTimeSlot currentTimeSlot = new ScheduleTimeSlot();
                currentTimeSlot.setName(results.getString("participant_name"));
                currentTimeSlot.setContestId(results.getInt("contest_id"));
                currentTimeSlot.setTimeSlot(results.getString("time_slot"));
                schedule.add(currentTimeSlot);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return schedule;
    }

    @Override
    public ScheduleTimeSlot createSchedule(ScheduleTimeSlot scheduleTimeSlot) {
        scheduleTimeSlot = new ScheduleTimeSlot();
        String sql = "INSERT INTO schedules_participants (schedule_id, participant_id, time_slot)" +
                "VALUES (?, ?, ?) " +
                "RETURNING contest_id;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, scheduleTimeSlot.get, contest.getContestDescription(),
                    contest.getDateAndTime(), contest.getContestLocation());
            if (result.next()) {
                contestToCreate.setContestId(result.getInt("contest_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return contestToCreate;
    }

    @Override
    public ScheduleTimeSlot updateSchedule(ScheduleTimeSlot scheduleTimeSlot) {
        String sql = "UPDATE contests " +
                "SET contest_name = ?, contest_description = ?, contest_date_time = ?, contest_location = ?" +
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

//    String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location " +
//            "FROM contests " +
//            "WHERE contest_id = ?";
//        try {
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
//        if (results.next()) {
//            contest = mapRowToContest(results);
//        }
//    } catch (CannotGetJdbcConnectionException e) {
//        throw new DaoException("Unable to connect to database or Server", e);
//    }
//        return contest;
//}


    //helper Method for Contest
    private Contest mapRowToContest(SqlRowSet rowSet) {
        Contest contest = new Contest();
        contest.setContestId(rowSet.getInt("contest_id"));
        contest.setContestName(rowSet.getString("contest_name"));
        contest.setContestDescription(rowSet.getString("contest_description"));
        contest.setDateAndTime(rowSet.getString("contest_date_time"));
        contest.setContestLocation(rowSet.getString("contest_location"));
        return contest;
    }


}
