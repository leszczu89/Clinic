package com.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserNotFoundException extends ResponseStatusException {

    private static final String MESSAGE = "User not found";

    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, MESSAGE);
    }
}
