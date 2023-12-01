package com.techelevator.controller;

import com.techelevator.dao.ContestDao;
import com.techelevator.model.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@PreAuthorize("isAuthenticated")
@RestController
@CrossOrigin
public class ContestController {

    @Autowired
    private ContestDao contestDao;

    @PreAuthorize("permitAll")
    @RequestMapping(path = "/contests", method = RequestMethod.GET)
    public List<Contest> listAllContests() {
        return contestDao.fetchListOfContests();
    }





}
