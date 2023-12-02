package com.techelevator.dao;

import com.techelevator.model.Contest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcContestDaoTests  extends BaseDaoTests {

    private JdbcContestDao sut;
    private JdbcTemplate jdbcTemplate;

    //test variables
    private final int NUMBER_OF_CONTESTS = 25;

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

}
