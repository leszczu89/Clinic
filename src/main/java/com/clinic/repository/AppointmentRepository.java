package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Doctor;
import com.clinic.domain.Specialization;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

    @Override
    Appointment save(Appointment appointment);

    List<Appointment> findAppointmentByDateAfter(Date date);

    List<Appointment> findAppointmentByDoctor(Doctor doctor);

    List<Appointment> findAppointmentByDateAfterAndDoctor(Date date, Doctor doctor);

    List<Appointment> findAppointmentsByDoctor_Specialization(Specialization specialization);

    List<Appointment> findAppointmentsByDoctor_SpecializationAndDateAfter(Specialization specialization, Date date);

    Appointment findAppointmentById(Long appointmentId);
}
