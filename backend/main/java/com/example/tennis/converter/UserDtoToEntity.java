package com.example.tennis.converter;

import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToEntity implements Converter<UserDto, User> {

    @Override
    public User convert(UserDto source) {
        User user = new User();

        user.setFirstName(source.getFirstName());
        user.setLastName(source.getLastName());
        user.setEmail(source.getEmail());
        user.setPhoneNumber(source.getPhoneNumber());
        return user;
    }
}
