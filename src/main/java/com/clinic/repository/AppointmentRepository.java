package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Doctor;
import com.clinic.domain.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Override
    Appointment save(Appointment appointment);

    List<Appointment> findAppointmentByDateAfter(LocalDate date);

    List<Appointment> findAppointmentByDoctor(Doctor doctor);

    List<Appointment> findAppointmentByDateAfterAndDoctor(LocalDate date, Doctor doctor);

    List<Appointment> findAppointmentsByDoctor_Specialization(Specialization specialization);

    List<Appointment> findAppointmentsByDoctor_SpecializationAndDateAfter(Specialization specialization, LocalDate date);

    Appointment findAppointmentById(Long appointmentId);

    @Override
    List<Appointment> findAll();
}
