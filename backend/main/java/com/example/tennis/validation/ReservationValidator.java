package com.example.tennis.validation;

import com.example.tennis.dto.ReservationDto;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.exception.NullFieldException;
import org.springframework.stereotype.Component;

@Component
public class ReservationValidator implements AbstractValidator<ReservationDto>{
    @Override
    public boolean isValid(ReservationDto reservationDto) throws BusinessException {
        if (reservationDto.getUser() == null) {
            throw new NullFieldException("user");
        }
        if (reservationDto.getCourt() == null) {
            throw new NullFieldException("court");
        }
        return true;
    }
}
