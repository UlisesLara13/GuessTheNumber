package com.example.GuessTheNumber.services.impl;

import com.example.GuessTheNumber.models.User;
import com.example.GuessTheNumber.repositores.UserRepository;
import com.example.GuessTheNumber.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

}
