package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.ScheduleTimeSlot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.List;

public class JdbcContestDaoTests  extends BaseDaoTests {

    private JdbcContestDao sut;
    private JdbcParticipantDao but;
    private JdbcTemplate jdbcTemplate;

    //test variables
    private final int NUMBER_OF_CONTESTS = 25;
    private final Contest TEST_CONTEST = new Contest();
    private final Contest UPDATED_CONTEST = new Contest();
    private final ScheduleTimeSlot TEST_TIME_SLOT = new ScheduleTimeSlot();
    private final ScheduleTimeSlot UPDATED_TIME_SLOT = new ScheduleTimeSlot();
    private final int EXPECTED_ID = 1; //set to a contest id that exists
    private final int ID_TO_FETCH = 5;
    private final int EXPECTED_ID_FROM_FETCH = 5;
    private final int NUMBER_OF_SCHEDULE_TIME_SLOTS = 50;

    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcContestDao(jdbcTemplate);

        jdbcTemplate = new JdbcTemplate(dataSource);
        but = new JdbcParticipantDao(jdbcTemplate);

        //set TEST_CONTEST properties
        TEST_CONTEST.setContestDescription("TEST DESCRIPTION");
        TEST_CONTEST.setContestLocation("TEST LOCATION");
        TEST_CONTEST.setContestName("TEST NAME");
        TEST_CONTEST.setDateAndTime("2025-05-05");

        //set UPDATED_CONTEST properties and id to EXPECTED_ID
        UPDATED_CONTEST.setContestDescription("UPDATED DESCRIPTION");
        UPDATED_CONTEST.setContestLocation("UPDATED LOCATION");
        UPDATED_CONTEST.setContestName("UPDATED NAME");
        UPDATED_CONTEST.setDateAndTime("2025-05-05");
        UPDATED_CONTEST.setContestId(EXPECTED_ID);

        //set TEST_SCHEDULE properties
        TEST_TIME_SLOT.setContestId(5);
        TEST_TIME_SLOT.setParticipantId(3);
        TEST_TIME_SLOT.setTimeSlot("11:00 AM");
        TEST_TIME_SLOT.setParticipantName("JOHN DOE");

        //set UPDATED_CONTEST properties and id to EXPECTED_ID
        UPDATED_TIME_SLOT.setContestId(3);
        UPDATED_TIME_SLOT.setParticipantId(4);
        UPDATED_TIME_SLOT.setTimeSlot("9:00 AM");
        UPDATED_TIME_SLOT.setParticipantName("JANE DOE");
        UPDATED_TIME_SLOT.setTimeSlotId(1);

    }

    @Test
    public void fetch_list_of_contests_returns_list() {
        List<Contest> returnedList = sut.fetchListOfContests();
        Assert.assertEquals(NUMBER_OF_CONTESTS, returnedList.size());
    }
    @Test
    public void fetch_contest_by_id(){
        Contest returnedContest = sut.fetchContestById(ID_TO_FETCH);
        Assert.assertEquals(EXPECTED_ID_FROM_FETCH, returnedContest.getContestId());
    }
    @Test
    public void create_Contest_Creates_Contest() {
        Contest returnedContest = sut.createContest(TEST_CONTEST);
        TEST_CONTEST.setContestId(returnedContest.getContestId());
        compareContests(returnedContest, TEST_CONTEST);
    }

    @Test
    public void update_Contest_Updates_Contest() {
        //Change properties of TEST_CONTEST and set id to EXPECTED_ID
        TEST_CONTEST.setContestDescription("UPDATED DESCRIPTION");
        TEST_CONTEST.setContestLocation("UPDATED LOCATION");
        TEST_CONTEST.setContestName("UPDATED NAME");
        TEST_CONTEST.setContestId(EXPECTED_ID);

        Contest returnedContest = sut.updateContest(TEST_CONTEST);
        //compare returnedContest to UPDATED_CONTEST
        compareContests(UPDATED_CONTEST, returnedContest);
    }

    @Test // todo
    public void delete_Contest_Deletes_Contest() {
        sut.deleteContest(2);
        Assert.assertEquals(0,sut.fetchContestById(2));
        Assert.assertEquals(0,but.fetchListOfParticipantByContestId(2));
    }

    @Test
    public void fetch_schedule_by_id_fetches_schedule() {
        List<ScheduleTimeSlot> returnedList = sut.fetchScheduleById(EXPECTED_ID);
        Assert.assertEquals(NUMBER_OF_SCHEDULE_TIME_SLOTS, returnedList.size());
    }

    @Test
    public void create_schedule_creates_schedule(){
        ScheduleTimeSlot returnedTimeSlot = sut.createSchedule(TEST_TIME_SLOT);
        TEST_TIME_SLOT.setContestId(returnedTimeSlot.getContestId());
        compareScheduleTimeSlots(returnedTimeSlot, TEST_TIME_SLOT);
    }
    @Test
    public void update_schedule_updates_schedule(){
        //Change properties of TEST_TIME_SLOT and set id to EXPECTED_ID
        UPDATED_TIME_SLOT.setContestId(3);
        UPDATED_TIME_SLOT.setParticipantId(4);
        UPDATED_TIME_SLOT.setTimeSlot("9:00 AM");
        UPDATED_TIME_SLOT.setParticipantName("JANE DOE");
        UPDATED_TIME_SLOT.setTimeSlotId(1);


        ScheduleTimeSlot returnedTimeslot = sut.updateSchedule(UPDATED_TIME_SLOT);
        //compare returnedContest to UPDATED_TIME_SLOT
        compareScheduleTimeSlots(UPDATED_TIME_SLOT, returnedTimeslot);
    }



    private void compareContests(Contest actual, Contest expected) {
        Assert.assertEquals(actual.getContestId(), expected.getContestId());
        Assert.assertEquals(actual.getContestName(), expected.getContestName());
        Assert.assertEquals(actual.getContestDescription(), expected.getContestDescription());
        Assert.assertEquals(actual.getContestLocation(), expected.getContestLocation());
    }

    private void compareScheduleTimeSlots(ScheduleTimeSlot actual, ScheduleTimeSlot expected) {
        Assert.assertEquals(actual.getContestId(), expected.getContestId());
        Assert.assertEquals(actual.getParticipantId(), expected.getParticipantId());
        Assert.assertEquals(actual.getTimeSlot(), expected.getTimeSlot());
        Assert.assertEquals(actual.getParticipantName(), expected.getParticipantName());
    }
}
