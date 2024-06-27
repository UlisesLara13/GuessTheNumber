package com.example.GuessTheNumber.controllers;

import com.example.GuessTheNumber.dtos.MatchDto;
import com.example.GuessTheNumber.dtos.UserDto;
import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.models.User;
import com.example.GuessTheNumber.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/users")
public class UserController {
    @Autowired
    private UserService userService;


}
