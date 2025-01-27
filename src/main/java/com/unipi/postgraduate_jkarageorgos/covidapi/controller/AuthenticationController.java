package com.unipi.postgraduate_jkarageorgos.covidapi.controller;

import com.unipi.postgraduate_jkarageorgos.covidapi.model.AuthenticationResponse;
import com.unipi.postgraduate_jkarageorgos.covidapi.model.User;
import com.unipi.postgraduate_jkarageorgos.covidapi.service.impl.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;

    @Autowired
    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody User request){
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
        return new ResponseEntity<>(authService.authenticate(request), HttpStatus.OK);
    }
}
