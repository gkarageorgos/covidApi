package com.unipi.postgraduate_jkarageorgos.covidapi.services.impl;

import com.unipi.postgraduate_jkarageorgos.covidapi.exceptions.UserNotFoundException;
import com.unipi.postgraduate_jkarageorgos.covidapi.models.AuthenticationResponse;
import com.unipi.postgraduate_jkarageorgos.covidapi.models.User;
import com.unipi.postgraduate_jkarageorgos.covidapi.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(User request) {
        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        user = repository.save(user);

        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = repository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User could not be found by username"));
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
    }
}
