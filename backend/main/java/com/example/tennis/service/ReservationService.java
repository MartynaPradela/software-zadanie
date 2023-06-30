package com.example.tennis.service;

import com.example.tennis.dto.ReservationDto;
import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.Reservation;
import com.example.tennis.exception.BusinessException;

import java.util.List;

public interface ReservationService {

    //Read
    List<Reservation> getAllReservations();

    //Save
    Reservation saveReservation(ReservationDto reservationDto) throws BusinessException;

    //Update
    void updateUser(UserDto userDto, Long reservationId);

    // Delete
    void deleteReservationById(Long reservationId);

}
