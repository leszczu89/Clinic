package com.clinic.repository;

import com.clinic.domain.Specialization;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpecializationRepositoryTest {

    @Autowired
    private SpecializationRepository specializationRepository;

    @AfterEach
    void cleanUpDatabase() {
        specializationRepository.deleteAll();
    }

    @Test
    void testSave() {
        //Given
        Specialization specialization = new Specialization("Pediatrics");
        //When
        Specialization saved = specializationRepository.save(specialization);
        Long id = saved.getId();
        //Then
        assertNotNull(saved);
        assertEquals(Optional.of(saved), specializationRepository.findById(id));
    }

    @Test
    void testDelete() {
        //Given
        Specialization specialization = new Specialization("Internist");
        Specialization saved = specializationRepository.save(specialization);
        Long id = saved.getId();
        //When
        specializationRepository.deleteById(id);
        //Then
        assertEquals(Optional.empty(), specializationRepository.findById(id));
        assertEquals(Collections.EMPTY_LIST, specializationRepository.findAll());
    }

    @Test
    void testFindAll() {
        //Given When
        List<Specialization> specializations = specializationRepository.findAll();
        //Then
        assertEquals(Collections.EMPTY_LIST, specializations);
    }
}