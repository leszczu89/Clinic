package com.clinic.controller;

import com.clinic.service.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final ModelMapper mapper;

    public AppointmentController(AppointmentService appointmentService, ModelMapper mapper) {
        this.appointmentService = appointmentService;
        this.mapper = mapper;
    }


}
