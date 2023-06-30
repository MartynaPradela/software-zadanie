package com.example.tennis.validation;

import com.example.tennis.dto.UserDto;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.exception.InvalidFieldLengthException;
import com.example.tennis.exception.NullFieldException;
import org.springframework.stereotype.Component;

@Component
public class UserValidator implements AbstractValidator<UserDto> {
    @Override
    public boolean isValid(UserDto userDto) throws BusinessException {
        if (userDto.getFirstName().isEmpty()) {
            throw new NullFieldException("firstName");
        }
        if (userDto.getLastName().isEmpty()) {
            throw new NullFieldException("lastName");
        }
        if (userDto.getEmail().isEmpty()) {
            throw new NullFieldException("email");
        }
        if (userDto.getPhoneNumber().isEmpty()) {
            throw new NullFieldException("phoneNumber");
        }
        if(!isLengthCorrect(userDto.getPhoneNumber(), 9)) {
            throw new InvalidFieldLengthException(9);
        }

        return true;
    }

    public boolean isLengthCorrect(String value, int minLength) {
        return  value.length() >= minLength;
    }

}
