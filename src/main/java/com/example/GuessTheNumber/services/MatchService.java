package com.example.GuessTheNumber.services;

import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.models.MatchDifficulty;
import com.example.GuessTheNumber.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    Match createMatch(User user, MatchDifficulty matchDifficulty);
}
