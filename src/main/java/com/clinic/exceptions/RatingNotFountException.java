package com.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RatingNotFountException extends ResponseStatusException {

    private static final String MESSAGE = "Rating not found";

    public RatingNotFountException() {
        super(HttpStatus.NOT_FOUND, MESSAGE);
    }
}
