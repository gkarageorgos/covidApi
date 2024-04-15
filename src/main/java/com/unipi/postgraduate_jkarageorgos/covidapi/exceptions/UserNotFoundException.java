package com.unipi.postgraduate_jkarageorgos.covidapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final int serialVerisionUID = 3;

    public UserNotFoundException(String message) {
        super(message);
    }
}
