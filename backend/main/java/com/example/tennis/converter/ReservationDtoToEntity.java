package com.example.tennis.converter;

import com.example.tennis.dto.ReservationDto;
import com.example.tennis.entity.Reservation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReservationDtoToEntity implements Converter<ReservationDto, Reservation> {

    @Override
    public Reservation convert(ReservationDto source) {

        Reservation reservation = new Reservation();

        //populate reservation with user
        reservation.setUser(source.getUser());

        //populate reservation with court
        reservation.setCourt(source.getCourt());

        return reservation;
    }
}
