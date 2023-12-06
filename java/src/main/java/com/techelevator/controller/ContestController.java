package com.techelevator.controller;

import com.techelevator.dao.ContestDao;
import com.techelevator.dao.ParticipantDao;
import com.techelevator.model.Contest;
import com.techelevator.model.OverallScore;
import com.techelevator.model.Participant;
import com.techelevator.model.ScheduleTimeSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
@PreAuthorize("isAuthenticated")
@RestController
@CrossOrigin
public class ContestController {

    @Autowired
    private ContestDao contestDao;
    @Autowired
    private ParticipantDao participantDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests", method = RequestMethod.GET)
    public List<Contest> listAllContests() {
        return contestDao.fetchListOfContests();
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}/overallScores", method = RequestMethod.GET)
    public List<OverallScore> listAllOverallScores(int contestId) {
        return participantDao.fetchListOfOverallScores(contestId);
    }
    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}", method = RequestMethod.GET)
    public Contest FetchContestById(@PathVariable int id) {
        return contestDao.fetchContestById(id);
    }


    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/contests", method = RequestMethod.POST)
    public Contest addNewContest(@RequestBody Contest contestToAdd) {

        return contestDao.createContest(contestToAdd);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}/participants", method = RequestMethod.GET)
    public List<Participant> listParticipantByContestId(@PathVariable int id){
        return participantDao.fetchListOfParticipantByContestId(id);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}/update", method = RequestMethod.PUT)
    public Contest updateContest(@RequestBody Contest contestToUpdate) {
        return contestDao.updateContest(contestToUpdate);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}", method = RequestMethod.DELETE)
    public int deleteContest(@PathVariable int id) {
        return contestDao.deleteContest(id);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}/schedule", method = RequestMethod.GET)
    public List<ScheduleTimeSlot> fetchScheduleById(@PathVariable int id) {
        return contestDao.fetchScheduleById(id);
    }
    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/contests/{id}/schedule", method = RequestMethod.POST)
    public ScheduleTimeSlot addNewScheduleTimeSlot(@RequestBody ScheduleTimeSlot scheduleTimeSlotToAdd) {

        return contestDao.createSchedule(scheduleTimeSlotToAdd);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}/schedule/update", method = RequestMethod.PUT)
    public ScheduleTimeSlot updateScheduleTimeSlot(@RequestBody ScheduleTimeSlot scheduleTimeSlotToAdd) {
        return contestDao.updateSchedule(scheduleTimeSlotToAdd);
    }

}
