package com.example.GuessTheNumber.services.impl;

import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.repositores.MatchRepository;
import com.example.GuessTheNumber.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

}
