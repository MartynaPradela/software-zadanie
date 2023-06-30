package com.example.tennis.controller;

import com.example.tennis.entity.Court;
import com.example.tennis.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourtController {

    private CourtService courtService;

    @Autowired
    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    //get all courts
    @GetMapping("/courts")
    public List<Court> getAllCourts() {

        return this.courtService.getAllCourts();
    }
}
