package com.clinic.repository;

import com.clinic.domain.Doctor;
import com.clinic.domain.Specialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private SpecializationRepository specializationRepository;

    @AfterEach
    void cleanUpDatabase() {
        doctorRepository.deleteAll();
        specializationRepository.deleteAll();
    }

    @Test
    void testSave() {
        //Given
        Specialization specialization = new Specialization("Internist");
        Specialization savedSpecialization = specializationRepository.save(specialization);
        Doctor doctor = new Doctor("email@com.pl", "pa", "la", savedSpecialization);
        //When
        Doctor saved = doctorRepository.save(doctor);
        Long id = saved.getId();
        //Then
        assertNotNull(saved);
        assertEquals(Optional.of(saved), doctorRepository.findById(id));
    }

    @Test
    void testDelete() {
        //Given
        Specialization specialization = new Specialization("Dentist");
        Specialization savedSpecialization = specializationRepository.save(specialization);
        Long specId = savedSpecialization.getId();
        Doctor doctor = new Doctor("email@cpl.pl", "name", "surname", savedSpecialization);

        Doctor saved = doctorRepository.save(doctor);
        Long id = saved.getId();
        //When
        doctorRepository.deleteById(id);
        //Then
        assertEquals(Optional.empty(), doctorRepository.findById(id));
        assertEquals(Optional.of(savedSpecialization), specializationRepository.findById(specId));
    }

    @Test
    void testFindAll() {
        //Given When
        List<Doctor> doctors = doctorRepository.findAll();
        //Then
        assertEquals(Collections.EMPTY_LIST, doctors);
    }
}