package com.example.tennis.service;

import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.User;
import com.example.tennis.exception.BusinessException;

import java.util.List;

public interface UserService {

    //save user
    User saveUser(UserDto userDto) throws BusinessException;

    //update user
    User updateUser(UserDto userDto, Long userId) throws BusinessException;

    //get and sort users by last name asc
    List<User> getAndSortAllUserByLastName();

}
