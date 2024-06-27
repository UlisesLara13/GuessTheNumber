package com.example.GuessTheNumber.services.impl;

import com.example.GuessTheNumber.entities.UserEntity;
import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.models.MatchDifficulty;
import com.example.GuessTheNumber.models.User;
import com.example.GuessTheNumber.repositores.UserRepository;
import com.example.GuessTheNumber.services.MatchService;
import com.example.GuessTheNumber.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Qualifier("matchService")
    @Autowired
    private MatchService matchService;

    @Override
    public User CreateUser(String username, String email) {

        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if(userEntityOptional.isPresent()) {
            return null;
        }else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(username);
            userEntity.setEmail(email);
            UserEntity userEntitySaved = userRepository.save(userEntity);
            return modelMapper.map(userEntitySaved, User.class);

        }

    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty matchDifficulty) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isPresent()) {
            throw new EntityNotFoundException();
        }
        else {
            User user = modelMapper.map(userEntity.get(), User.class);
            return matchService.createMatch(user, matchDifficulty);
        }
    }
}
