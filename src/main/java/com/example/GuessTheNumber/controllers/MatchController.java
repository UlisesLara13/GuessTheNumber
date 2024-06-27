package com.example.GuessTheNumber.controllers;
import com.example.GuessTheNumber.dtos.MatchDto;
import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

}
