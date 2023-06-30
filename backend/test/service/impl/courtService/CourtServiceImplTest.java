package com.example.tennis.service.impl.courtService;

import com.example.tennis.TennisApplication;
import com.example.tennis.entity.Court;
import com.example.tennis.repository.CourtRepository;
import com.example.tennis.service.CourtService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootTest
public class CourtServiceImplTest {

    @Autowired
    private CourtService courtService;

    @Autowired
    private CourtRepository courtRepository;

    @Test
    void shouldGetAllCourts() {

        int expectedNumberOfItems = 27;
        List<Court> courtList;
        ConfigurableApplicationContext context = SpringApplication.run(TennisApplication.class);

        courtList = context.getBean(CourtService.class).getAllCourts();

        Assertions.assertEquals(expectedNumberOfItems, courtList.size());
    }
}
