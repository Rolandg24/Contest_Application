package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.Participant;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcParticipantDaoTests extends BaseDaoTests {

    private JdbcParticipantDao sut;
    private JdbcTemplate jdbcTemplate;

    //test variables
    private final int NUMBER_OF_PARTICIPANTS_IN_CONTEST_1 = 25;
    private final int CONTEST_1 = 1;

    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcParticipantDao(jdbcTemplate);
    }

    @Test
    public void fetch_list_of_contests_returns_list() {
        List<Participant> returnedList = sut.fetchListOfParticipantByContestId(CONTEST_1);
        Assert.assertEquals(NUMBER_OF_PARTICIPANTS_IN_CONTEST_1, returnedList.size());
    }

}
