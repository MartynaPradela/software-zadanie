package com.example.tennis.service.impl;

import com.example.tennis.converter.ReservationDtoToEntity;
import com.example.tennis.converter.UserDtoToEntity;
import com.example.tennis.dto.ReservationDto;
import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.Reservation;
import com.example.tennis.entity.User;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.exception.InvalidDataException;
import com.example.tennis.repository.ReservationRepository;
import com.example.tennis.service.ReservationService;
import com.example.tennis.validation.ReservationValidator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationDtoToEntity reservationDtoToEntity;
    private UserDtoToEntity userDtoToEntity;
    private ReservationValidator reservationValidator;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationDtoToEntity reservationDtoToEntity, UserDtoToEntity userDtoToEntity, ReservationValidator reservationValidator) {
        this.reservationRepository = reservationRepository;
        this.reservationDtoToEntity = reservationDtoToEntity;
        this.userDtoToEntity = userDtoToEntity;
        this.reservationValidator = reservationValidator;
    }

    //Read reservation list
    @Override
    public List<Reservation> getAllReservations() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    //Save reservation
    @Override
    @Transactional
    public Reservation saveReservation(@RequestBody ReservationDto reservationDto) throws BusinessException {

        if (!this.reservationValidator.isValid(reservationDto)) {
            throw new InvalidDataException("Invalid input data");
        }

        Reservation reservation = reservationDtoToEntity.convert(reservationDto);

        //save to the database
        return reservationRepository.save(reservation);
    }

    //Update user in reservation
    public void updateUser(UserDto userDto, Long reservationId){

        try {
            Reservation reservation = getReservation(reservationId);
            User user = userDtoToEntity.convert(userDto);
            reservation.setUser(user);
            reservationRepository.save(reservation);
        }
        catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "invalid reservation ID");
        }
    }

    //Delete reservation
    @Override
    public void deleteReservationById(Long reservationId) {

        reservationRepository.deleteById(reservationId);
    }

    public Reservation getReservation(Long reservationId){

        try {
            return reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "reservation not found"));
        }
        catch (NumberFormatException e){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Invalid reservation id");
        }
    }
}
