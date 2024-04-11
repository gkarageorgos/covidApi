package com.unipi.postgraduate_jkarageorgos.covidapi.exceptions;

public class DataNotFoundException extends RuntimeException {
    private static final int serialVerisionUID = 2;

    public DataNotFoundException(String message) {
        super(message);
    }
}
