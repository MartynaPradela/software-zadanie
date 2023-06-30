package com.example.tennis.controller;

import com.example.tennis.dto.UserDto;
import com.example.tennis.entity.User;
import com.example.tennis.exception.BusinessException;
import com.example.tennis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
    this.userService = userService;
    }

    //get and sort user by last name
    @GetMapping("/all/sort")
    public List<User> getAndSortAllUsersByLastName() {

        return this.userService.getAndSortAllUserByLastName();
    }

    //add user
    @PostMapping("/add")
    public User addUser(@RequestBody UserDto userDto) throws BusinessException {

        return userService.saveUser(userDto);
    }

    //update user
    @PutMapping("update/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable("id") Long userId) throws BusinessException {

        userService.updateUser(userDto, userId);
    }

}
