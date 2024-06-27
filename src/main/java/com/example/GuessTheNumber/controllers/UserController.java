package com.example.GuessTheNumber.controllers;

import com.example.GuessTheNumber.dtos.MatchDto;
import com.example.GuessTheNumber.dtos.UserDto;
import com.example.GuessTheNumber.models.Match;
import com.example.GuessTheNumber.models.MatchDifficulty;
import com.example.GuessTheNumber.models.User;
import com.example.GuessTheNumber.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/guess-number/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        User user = userService.CreateUser(userDto.getUserName(),userDto.getEmail());
        UserDto userDtoCreated = modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDtoCreated);
    }

    @PostMapping("/{userId}/matches/{difficulty}")
    public ResponseEntity<UserDto> createUserMatch(@PathVariable Long userId,@PathVariable MatchDifficulty difficulty) {
        Match match = userService.createUserMatch(userId,difficulty);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }


}
