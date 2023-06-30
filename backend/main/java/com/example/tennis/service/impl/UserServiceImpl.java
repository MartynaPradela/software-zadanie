package com.example.tennis.service.impl;

import com.example.tennis.converter.UserDtoToEntity;
import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.User;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.exception.InvalidDataException;
import com.example.tennis.repository.UserRepository;
import com.example.tennis.service.UserService;
import com.example.tennis.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserDtoToEntity userDtoToEntity;

    private UserValidator userValidator;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDtoToEntity userDtoToEntity, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userDtoToEntity = userDtoToEntity;
        this.userValidator = userValidator;
    }

    //add user
    @Override
    public User saveUser(UserDto userDto) throws BusinessException {

        if (!this.userValidator.isValid(userDto)) {
            throw new InvalidDataException("Invalid input data");
        }

        User user = userDtoToEntity.convert(userDto);
        return userRepository.save(user);
    }

    //update user
    @Override
    public User updateUser(UserDto userDto, Long userId) throws BusinessException {

        if (!this.userValidator.isValid(userDto)) {
            throw new InvalidDataException("Invalid input data");
        }
        User userToEntity = userDtoToEntity.convert(userDto);

        User user = userRepository.findById(userId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        user.setFirstName(userToEntity.getFirstName());
        user.setLastName(userToEntity.getLastName());
        user.setEmail(userToEntity.getEmail());
        user.setPhoneNumber(userToEntity.getPhoneNumber());

        return userRepository.save(user);
    }

    //get and sort list by last name
    @Override
    public List<User> getAndSortAllUserByLastName() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }
}
