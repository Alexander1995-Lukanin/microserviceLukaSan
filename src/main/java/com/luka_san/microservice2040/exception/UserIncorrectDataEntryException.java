package com.luka_san.microservice2040.exception;

public class UserIncorrectDataEntryException extends RuntimeException {
    public UserIncorrectDataEntryException(String message) {
        super(message);
    }
}
