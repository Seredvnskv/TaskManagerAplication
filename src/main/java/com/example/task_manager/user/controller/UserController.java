package com.example.task_manager.user.controller;

import com.example.task_manager.user.User;
import com.example.task_manager.user.dto.ReadUserDTO;
import com.example.task_manager.user.mapper.UserMapper;
import com.example.task_manager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ResponseEntity<List<ReadUserDTO>> getAllUsers() {
        List<User> users = userService.getUsers();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<ReadUserDTO> dtos = userMapper.toDTO(users);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }
}
