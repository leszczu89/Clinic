package com.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SpecializationNotFoundException extends ResponseStatusException {

    private static final String MESSAGE = "Specialization not found";

    public SpecializationNotFoundException() {
        super(HttpStatus.NOT_FOUND, MESSAGE);
    }
}
