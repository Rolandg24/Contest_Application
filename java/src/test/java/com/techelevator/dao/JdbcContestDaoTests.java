package com.techelevator.dao;

import com.techelevator.model.Contest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcContestDaoTests  extends BaseDaoTests {

    private JdbcContestDao sut;
    private JdbcTemplate jdbcTemplate;

    //test variables
    private final int NUMBER_OF_CONTESTS = 25;
    private final Contest TEST_CONTEST = new Contest();
    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcContestDao(jdbcTemplate);
    }

    @Test
    public void fetch_list_of_contests_returns_list() {
        List<Contest> returnedList = sut.fetchListOfContests();
        Assert.assertEquals(NUMBER_OF_CONTESTS, returnedList.size());
    }

    @Test
    public void create_Contest_Creates_Contest() {
        TEST_CONTEST.setContestDescription("TEST DESCRIPTION");
        TEST_CONTEST.setContestLocation("TEST LOCATION");
        TEST_CONTEST.setContestName("TEST NAME");
        TEST_CONTEST.setDateAndTime(LocalDate.ofEpochDay(2025-05-05));

        Contest returnedContest = sut.createContest(TEST_CONTEST);
        TEST_CONTEST.setContestId(returnedContest.getContestId());
        compareContests(returnedContest, TEST_CONTEST);
    }


    private void compareContests(Contest actual, Contest expected) {
        Assert.assertEquals(actual.getContestId(), expected.getContestId());
        Assert.assertEquals(actual.getContestName(), expected.getContestName());
        Assert.assertEquals(actual.getContestDescription(), expected.getContestDescription());
        Assert.assertEquals(actual.getContestLocation(), expected.getContestLocation());
    }

}
