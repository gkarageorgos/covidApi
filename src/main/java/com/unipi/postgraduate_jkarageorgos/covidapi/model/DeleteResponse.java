package com.unipi.postgraduate_jkarageorgos.covidapi.model;

public class DeleteResponse {
    private String successMessage;

    public DeleteResponse(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }
}
