package com.unipi.postgraduate_jkarageorgos.covidapi.exceptions;

public class AreaNotFoundException extends RuntimeException {
    private static final int serialVerisionUID = 1;

    public AreaNotFoundException(String message) {
        super(message);
    }
}
