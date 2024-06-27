package com.example.GuessTheNumber.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
public class User {
    private Long id;
    private String userName;
    private String email;
}
