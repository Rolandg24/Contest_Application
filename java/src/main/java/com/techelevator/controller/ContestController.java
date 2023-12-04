package com.techelevator.controller;

import com.techelevator.dao.ContestDao;
import com.techelevator.dao.ParticipantDao;
import com.techelevator.model.Contest;
import com.techelevator.model.Participant;
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
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/contests", method = RequestMethod.POST)
    public Contest addNewContest(@RequestBody Contest contestToAdd) {

        return contestDao.createContest(contestToAdd);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}", method = RequestMethod.GET)
    public List<Participant> listParticipantByContestId(@PathVariable int id){
        return participantDao.fetchListOfParticipantByContestId(id);
    }

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests/{id}", method = RequestMethod.PUT)
    public Contest updateContest(@RequestBody Contest contestToUpdate) {
        return contestDao.updateContest(contestToUpdate);
    }



}
