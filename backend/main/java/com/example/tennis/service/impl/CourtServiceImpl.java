package com.example.tennis.service.impl;

import com.example.tennis.entity.Court;
import com.example.tennis.repository.CourtRepository;
import com.example.tennis.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtServiceImpl implements CourtService {
    private CourtRepository courtRepository;

    @Autowired
    public CourtServiceImpl(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    //Read court list
    @Override
    public List<Court> getAllCourts() {

        return (List<Court>) courtRepository.findAll();
    }
}
