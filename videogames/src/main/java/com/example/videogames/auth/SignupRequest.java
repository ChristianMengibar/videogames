package com.example.videogames.auth;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;
    private String password;
}
