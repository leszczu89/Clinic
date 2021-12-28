package com.clinic.service;

import com.clinic.domain.Appointment;
import com.clinic.exceptions.AppointmentNotFoundException;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Appointment save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public Appointment update(Appointment appointment) throws AppointmentNotFoundException {
        if (appointmentRepository.existsById(appointment.getId())) {
            return appointmentRepository.save(appointment);
        } else throw new AppointmentNotFoundException();
    }

    public void delete(Long appointmentId) throws AppointmentNotFoundException {
        if (appointmentRepository.existsById(appointmentId)) {
            appointmentRepository.deleteById(appointmentId);
        } else throw new AppointmentNotFoundException();
    }

    public Appointment get(Long appointmentId) throws AppointmentNotFoundException {
        return Optional.of(appointmentRepository.findAppointmentById(appointmentId))
                .orElseThrow(AppointmentNotFoundException::new);
    }
}
