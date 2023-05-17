package com.example.feignapi.commons.dto;

public class HelloResponse {
    private String message;

    public HelloResponse() {}

    public HelloResponse(String s) {
        this.message = s;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloResponse(message=%s)", this.message);
    }
}
