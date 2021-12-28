package com.clinic.repository;

import com.clinic.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PatientRepository extends CrudRepository<Patient, Long> {

    void deleteById(Long patientId);

    @Override
    List<Patient> findAll();
}
