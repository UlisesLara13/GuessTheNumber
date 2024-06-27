package com.example.GuessTheNumber.dtos;

import com.example.GuessTheNumber.models.MatchDifficulty;
import com.example.GuessTheNumber.models.MatchStatus;
import com.example.GuessTheNumber.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatchDto {

    private Long id;

    private MatchDifficulty difficulty;

    private Integer remainingTries;

}
