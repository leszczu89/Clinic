package com.clinic.repository;

import com.clinic.domain.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @AfterEach
    void cleanUpDatabase() {
        patientRepository.deleteAll();
    }

    @Test
    void testSave() {
        //Given
        Patient patient = new Patient("email@m.ok", "name", "surname");
        //When
        Patient savedPatient = patientRepository.save(patient);
        Long id = savedPatient.getId();
        //Then
        assertNotNull(savedPatient);
        assertEquals(Optional.of(savedPatient), patientRepository.findById(id));
    }

    @Test
    void testDeleteById() {
        //Given
        Patient patient = new Patient("email@m.ok", "name", "surname");
        Patient savedPatient = patientRepository.save(patient);
        Long id = savedPatient.getId();
        //When
        patientRepository.deleteById(id);
        //Then
        assertEquals(Optional.empty(), patientRepository.findById(id));
        assertEquals(Collections.EMPTY_LIST, patientRepository.findAll());
    }

    @Test
    void testFindAll() {
        //Given When
        List<Patient> patients = patientRepository.findAll();
        //Then
        assertEquals(Collections.EMPTY_LIST, patients);
    }

    @Test
    void testFindById() {
        //Given
        Patient patient = new Patient("email@email.com", "Pablo", "garcia");
        Patient savedPatient = patientRepository.save(patient);
        Long id = savedPatient.getId();
        //When
        Optional<Patient> searchedPatient = patientRepository.findById(id);
        //Then
        assertEquals(Optional.of(savedPatient), searchedPatient);
    }
}