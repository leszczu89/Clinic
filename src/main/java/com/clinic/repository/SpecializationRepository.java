package com.clinic.repository;

import com.clinic.domain.Specialization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecializationRepository extends CrudRepository<Specialization, Long> {

    @Override
    Specialization save(Specialization specialization);

    @Override
    List<Specialization> findAll();
}
