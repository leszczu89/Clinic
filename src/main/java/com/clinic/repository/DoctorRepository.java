package com.clinic.repository;

import com.clinic.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    @Override
    List<Doctor> findAll();
}
