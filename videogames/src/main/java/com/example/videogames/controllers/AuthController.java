package com.example.videogames.controllers;

import com.example.videogames.auth.JwtService;
import com.example.videogames.auth.LoginRequest;
import com.example.videogames.auth.SignupRequest;
import com.example.videogames.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<Map> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                ));
        return ResponseEntity.ok(Map.of("token",
                jwtService.createToken(authentication.getName()
                ))
        );
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDetails> signup(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(
//                jwtService.createToken(authentication.getName())
                userDetailsService.create(signupRequest) //pasar por mapper
        );
    }
}
