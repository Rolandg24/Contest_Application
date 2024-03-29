package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Contest;
import com.techelevator.model.ScheduleTimeSlot;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//import java.util.Map;
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
    public List<Contest> fetchListOfContests() { // AJH: updated to add category name
        List<Contest> contestList = new ArrayList<>();
        String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location, contest_categories.category_name, image_url " +
                "FROM contests " +
                "JOIN contest_categories on contests.category_id = contest_categories.category_id";
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
    public Contest fetchContestById(int id) { // AJH: updated to add category name
        Contest contest = null;

        String sql = "SELECT contest_id, contest_name, contest_description, contest_date_time, contest_location, contest_categories.category_name, image_url " +
                "FROM contests " +
                "JOIN contest_categories on contests.category_id = contest_categories.category_id " +
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
    public Contest createContest(Contest contest) { // AJH: updated to add category name
        Contest contestToCreate = contest;
        String sql = "INSERT INTO contests (contest_name, contest_description, contest_date_time, contest_location, category_id, image_url) " +
                "VALUES (?, ?, ?, ?,(SELECT category_id FROM contest_categories WHERE category_name = ?), ?) " +
                "RETURNING contest_id";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, contest.getContestName(), contest.getContestDescription(),
                    contest.getDateAndTime(), contest.getContestLocation(), contest.getContestCategoryName(), contest.getContestImageUrl());
            if (result.next()) {
                contestToCreate.setContestId(result.getInt("contest_id"));
//                sendImgUrlToCloudinary(contestToCreate.getContestImageUrl(),contestToCreate.getContestId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return contestToCreate;



    }

    @Override
    public Contest updateContest(Contest contest) { // AJH: updated to add category name
        String sql = "UPDATE contests " +
                "SET contest_name = ?, contest_description = ?, contest_date_time = ?, contest_location = ?, " +
                "category_id = (SELECT category_id FROM contest_categories WHERE category_name = ?), image_url = ? " +
                "WHERE contest_id = ?";
        int rowCount = NOT_UPDATED;
        try {
            rowCount = jdbcTemplate.update(sql, contest.getContestName(), contest.getContestDescription(), contest.getDateAndTime(),
                    contest.getContestLocation(),  contest.getContestCategoryName(),  contest.getContestImageUrl(), contest.getContestId());
//            sendImgUrlToCloudinary(contest.getContestImageUrl(),contest.getContestId());
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
    public int deleteContest(int contestId) { // AJH: no adjustments needed for adding category to contest

        String sql = "START TRANSACTION; " +
                "DELETE FROM time_slots " +
                "WHERE participant_id IN (SELECT participant_id FROM participants WHERE contest_id = ?); " +
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
            return jdbcTemplate.update(sql, contestId, contestId, contestId);
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

        String sql = "SELECT time_slots.time_slot_id, participants.participant_id, time_slots.time_slot, participants.participant_name " +
                "FROM participants " +
                "JOIN time_slots ON participants.participant_id = time_slots.participant_id " +
                "WHERE time_slots.contest_id = ? " +
                "ORDER BY time_slots.time_slot;";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, contestId);
            while (results.next()) {
                ScheduleTimeSlot currentTimeSlot = new ScheduleTimeSlot();
                currentTimeSlot.setTimeSlotId((results.getInt("time_slot_id")));
                currentTimeSlot.setContestId(contestId);
                currentTimeSlot.setTimeSlot(results.getString("time_slot"));
                currentTimeSlot.setParticipantId(results.getInt("participant_id"));
                currentTimeSlot.setParticipantName((results.getString("participant_name")));
                schedule.add(currentTimeSlot);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return schedule;
    }

    @Override
    public ScheduleTimeSlot createSchedule(ScheduleTimeSlot scheduleTimeSlot) {
        ScheduleTimeSlot scheduleTimeSlotToUpdate = scheduleTimeSlot;
        String sql = "INSERT INTO time_slots (contest_id, participant_id, time_slot)" +
                "VALUES (?, ?, ?) " +
                "RETURNING time_slot_id;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, scheduleTimeSlot.getContestId(), scheduleTimeSlot.getParticipantId(),
                    scheduleTimeSlot.getTimeSlot());
            if (result.next()) {
                scheduleTimeSlotToUpdate.setTimeSlotId(result.getInt("time_slot_id"));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        return scheduleTimeSlotToUpdate;
    }

    @Override
    public ScheduleTimeSlot updateSchedule(ScheduleTimeSlot scheduleTimeSlot) {
        String sql = "UPDATE time_slots " +
                "SET contest_id = ?, participant_id = ?, time_slot = ? " +
                "WHERE time_slot_id = ?";
        int rowCount = NOT_UPDATED;
        try {
            rowCount = jdbcTemplate.update(sql, scheduleTimeSlot.getContestId(), scheduleTimeSlot.getParticipantId(), scheduleTimeSlot.getTimeSlot(), scheduleTimeSlot.getTimeSlotId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to database or Server", e);
        }
        if (rowCount < UPDATED) {
            throw new DaoException("Error. Contest was not updated");
        }
        return scheduleTimeSlot;
    }


//    private boolean sendImgUrlToCloudinary(String url, int contestId) {
//        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
//                "cloud_name", "dmptbrbof",
//                "api_key", "757429462643496",
//                "api_secret", "LMbxAg8q-y4aUSSpU05ZDYNPvM0"));
//
//        try {
//            Map uploadResult = cloudinary.uploader().upload(
//                    url,
//                    ObjectUtils.asMap("public_id", String.valueOf(contestId)));
//            System.out.println(uploadResult);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
    //helper Method for Contest
    private Contest mapRowToContest(SqlRowSet rowSet) {
        Contest contest = new Contest();
        contest.setContestId(rowSet.getInt("contest_id"));
        contest.setContestName(rowSet.getString("contest_name"));
        contest.setContestDescription(rowSet.getString("contest_description"));
        contest.setDateAndTime(rowSet.getString("contest_date_time"));
        contest.setContestLocation(rowSet.getString("contest_location"));
        contest.setContestCategoryName(rowSet.getString("category_name"));
        contest.setContestImageUrl(rowSet.getString("image_url"));
        return contest;
    }
}
