package com.clinic.repository;

import com.clinic.domain.Appointment;
import com.clinic.domain.Doctor;
import com.clinic.domain.Specialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private SpecializationRepository specializationRepository;
    @Autowired
    private DoctorRepository doctorRepository;

    private Specialization savedSpecialization;
    private Doctor doctor;
    private Doctor savedDoctor;
    private Appointment appointment;
    private Appointment thirdAppointment;
    private Appointment firstAppointment;
    private Appointment secondAppointment;
    private Specialization savedSpecialization2;
    private Appointment fourthAppointment;

    @BeforeEach
    void prepareDataFotTests() {
        Specialization specialization = new Specialization("Pediatric");
        savedSpecialization = specializationRepository.save(specialization);

        doctor = new Doctor("email@mail.com", "pa", "la", savedSpecialization);
        savedDoctor = doctorRepository.save(doctor);

        Specialization specialization2 = new Specialization("Internist");
        savedSpecialization2 = specializationRepository.save(specialization2);

        Doctor doctor2 = new Doctor("e@e.com", "name", "surname", savedSpecialization2);
        Doctor savedDoctor2 = doctorRepository.save(doctor2);

        thirdAppointment = new Appointment(LocalDate.of(2022, 2, 10), LocalTime.of(12, 30), savedDoctor);
        firstAppointment = new Appointment(LocalDate.of(2022, 1, 2), LocalTime.of(12, 0), savedDoctor);
        secondAppointment = new Appointment(LocalDate.of(2022, 3, 12), LocalTime.of(16, 15), savedDoctor);
        fourthAppointment = new Appointment(LocalDate.of(2022, 4, 20), LocalTime.of(9, 0), savedDoctor2);
    }

    @AfterEach
    void cleanUpDatabase() {
        appointmentRepository.deleteAll();
        doctorRepository.deleteAll();
        specializationRepository.deleteAll();
    }

    @Test
    void save() {
        //Given

        //When
        appointment = appointmentRepository.save(firstAppointment);
        Long appId = appointment.getId();
        //Then
        assertNotNull(appointment);
        assertEquals(appointment, appointmentRepository.findAppointmentById(appId));
    }

    @Test
    void findAppointmentByDateAfter() {
        //Given
        appointment = appointmentRepository.save(thirdAppointment);
        appointmentRepository.save(firstAppointment);

        appointmentRepository.save(secondAppointment);
        //When
        List<Appointment> foundAppointments = appointmentRepository.findAppointmentByDateAfter(LocalDate.of(2022, 2, 1));
        List<Appointment> allAppointments = appointmentRepository.findAll();
        //Then
        assertEquals(2, foundAppointments.size());
        assertEquals(3, allAppointments.size());
    }

    @Test
    void findAppointmentByDoctor() {
        //Given
        appointmentRepository.save(firstAppointment);
        appointmentRepository.save(secondAppointment);
        appointmentRepository.save(thirdAppointment);

        Doctor secondDoctor = new Doctor("mail@com.com", "test", "test", savedSpecialization);
        Doctor savedSecondDoctor = doctorRepository.save(secondDoctor);
        //When
        List<Appointment> appointments = appointmentRepository.findAppointmentByDoctor(doctor);
        List<Appointment> appointmentsOfSecondDoctor = appointmentRepository.findAppointmentByDoctor(savedSecondDoctor);
        //Then
        assertEquals(3, appointments.size());
        assertEquals(Collections.EMPTY_LIST, appointmentsOfSecondDoctor);
    }

    @Test
    void findAppointmentByDateAfterAndDoctor() {
        //Given
        appointmentRepository.save(firstAppointment);
        appointmentRepository.save(secondAppointment);
        appointmentRepository.save(thirdAppointment);
        //When
        List<Appointment> appointmentCheck1 = appointmentRepository.findAppointmentByDateAfterAndDoctor(LocalDate.of(2022, 2, 2), savedDoctor);
        List<Appointment> appointmentCheck2 = appointmentRepository.findAppointmentByDateAfterAndDoctor(LocalDate.of(2022, 3, 2), savedDoctor);
        //Then
        assertEquals(2, appointmentCheck1.size());
        assertEquals(1, appointmentCheck2.size());
    }

    @Test
    void findAppointmentsByDoctor_Specialization() {
        //Given
        appointmentRepository.save(firstAppointment);
        appointmentRepository.save(secondAppointment);
        appointmentRepository.save(thirdAppointment);
        appointmentRepository.save(fourthAppointment);
        //When
        List<Appointment> pediatricAppointment = appointmentRepository.findAppointmentsByDoctor_Specialization(savedSpecialization2);
        List<Appointment> internistAppointment = appointmentRepository.findAppointmentsByDoctor_Specialization(savedSpecialization);
        //Then
        assertEquals(1, pediatricAppointment.size());
        assertEquals(3, internistAppointment.size());
    }

    @Test
    void findAppointmentsByDoctor_SpecializationAndDateAfter() {
        //Given
        appointmentRepository.save(firstAppointment);
        appointmentRepository.save(secondAppointment);
        appointmentRepository.save(thirdAppointment);
        appointmentRepository.save(fourthAppointment);
        //When
        List<Appointment> foundAppointments = appointmentRepository.findAppointmentsByDoctor_SpecializationAndDateAfter(savedSpecialization, LocalDate.of(2022, 2, 9));
        //Then
        assertEquals(2, foundAppointments.size());
    }

    @Test
    void findAppointmentById() {
        //Given
        Appointment first = appointmentRepository.save(firstAppointment);
        Long id = first.getId();
        //When
        Appointment found = appointmentRepository.findAppointmentById(id);
        //Then
        assertEquals(first, found);
    }

    @Test
    void deleteAppointment() {
        //Given
        Appointment firstSavedAppointment = appointmentRepository.save(firstAppointment);
        Long id = firstSavedAppointment.getId();
        appointmentRepository.save(secondAppointment);
        appointmentRepository.save(thirdAppointment);
        appointmentRepository.save(fourthAppointment);
        //When
        List<Appointment> beforeDeleteList = appointmentRepository.findAll();
        appointmentRepository.deleteById(id);
        List<Appointment> afterDeleteList = appointmentRepository.findAll();
        //Then
        assertEquals(4, beforeDeleteList.size());
        assertEquals(3, afterDeleteList.size());
        assertNull(appointmentRepository.findAppointmentById(id));
        assertEquals(2, doctorRepository.findAll().size());
        assertEquals(2, specializationRepository.findAll().size());
    }
}