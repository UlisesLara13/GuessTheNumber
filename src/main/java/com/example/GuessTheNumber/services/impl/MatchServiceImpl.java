package com.example.GuessTheNumber.services.impl;

import com.example.GuessTheNumber.entities.MatchEntity;
import com.example.GuessTheNumber.entities.UserEntity;
import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.models.MatchDifficulty;
import com.example.GuessTheNumber.models.MatchStatus;
import com.example.GuessTheNumber.models.User;
import com.example.GuessTheNumber.repositores.MatchRepository;
import com.example.GuessTheNumber.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {
    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public Match createMatch(User user, MatchDifficulty matchDifficulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));
        matchEntity.setDifficulty(matchDifficulty);
        switch (matchDifficulty) {
            case EASY -> matchEntity.setRemainingTries(10);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case HARD -> matchEntity.setRemainingTries(5);
        }
        matchEntity.setNumbeToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        MatchEntity savedMatchEntity = matchRepository.save(matchEntity);
        return modelMapper.map(savedMatchEntity, Match.class);
    }
}
