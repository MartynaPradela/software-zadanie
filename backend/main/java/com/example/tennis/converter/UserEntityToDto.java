package com.example.tennis.converter;

import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserEntityToDto implements Converter<User, UserDto> {

    @Override
    public UserDto convert(User source) {
        UserDto userDto = new UserDto(source.getId(), source.getFirstName(), source.getLastName(), source.getEmail(),source.getPhoneNumber());
        return userDto;
    }
}
