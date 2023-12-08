package com.techelevator.dao;

import com.techelevator.model.Contest;
import com.techelevator.model.OverallScore;
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
    private final int NUMBER_OF_SCORES_IN_CONTEST = 25;
    private final int CONTEST_1 = 1;
    private final OverallScore TEST_SCORE = new OverallScore();



    @Before
    public void setup() {
        jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcParticipantDao(jdbcTemplate);

        //set TEST_SCORE properties
        TEST_SCORE.setContestId(1);
        TEST_SCORE.setParticipantId(3);
        TEST_SCORE.setOverallScore(99);
        TEST_SCORE.setParticipantName("Java Green");

    }

    @Test
    public void fetch_list_of_participants_by_contest_id_returns_list() {
        List<Participant> returnedList = sut.fetchListOfParticipantByContestId(CONTEST_1);
        Assert.assertEquals(NUMBER_OF_PARTICIPANTS_IN_CONTEST_1, returnedList.size());
    }

    @Test
    public void fetch_list_of_overall_scores_returns_list() {
        List<OverallScore> returnedList = sut.fetchListOfOverallScores(CONTEST_1);
        Assert.assertEquals(NUMBER_OF_SCORES_IN_CONTEST,returnedList.size());
    }
    @Test
    public void create_overall_scores_creates_overall_score() {
        OverallScore returnedScore = sut.createOverallScore(TEST_SCORE);
        TEST_SCORE.setOverallScoreId(returnedScore.getOverallScoreId());
        compareOverallScores(returnedScore, TEST_SCORE);
    }

    private void compareOverallScores(OverallScore actual,OverallScore expected) {
        Assert.assertEquals(actual.getOverallScoreId(), expected.getOverallScoreId());
        Assert.assertEquals(actual.getOverallScoreId(), expected.getOverallScoreId());
        Assert.assertEquals(actual.getParticipantId(), expected.getParticipantId());
        Assert.assertEquals(actual.getOverallScore(), expected.getOverallScore());
        Assert.assertEquals(actual.getParticipantName(), expected.getParticipantName());
    }

}
