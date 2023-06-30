package com.example.tennis.controller;

import com.example.tennis.dto.ReservationDto;
import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.Reservation;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    //get all reservations
    @GetMapping("/all")
    public List<Reservation> getAllCourts() {

        return this.reservationService.getAllReservations();
    }

    //add new reservation
    @PostMapping("/form")
    public Reservation addReservation(@RequestBody ReservationDto reservationDto) throws BusinessException {

        return reservationService.saveReservation(reservationDto);
    }

    //update reservation by reservationId
    @PutMapping("/reservations/{id}")
    public void updateReservation(@RequestBody UserDto userDto, @PathVariable("id") Long reservationId) {

        reservationService.updateUser(userDto, reservationId);
    }

    //delete reservation by reservationId
    @DeleteMapping("/reservations/{id}")
    public void deleteReservation(@PathVariable("id") Long reservationId) {

        reservationService.deleteReservationById(reservationId);
    }

}
