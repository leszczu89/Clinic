package com.clinic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AppointmentNotFoundException extends ResponseStatusException {

    private static final String MESSAGE = "Appointment not found";

    public AppointmentNotFoundException() {
        super(HttpStatus.NOT_FOUND, MESSAGE);
    }
}
