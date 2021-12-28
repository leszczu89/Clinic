package com.clinic.service;

import com.clinic.domain.Specialization;
import com.clinic.exceptions.SpecializationNotFoundException;
import com.clinic.repository.SpecializationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationService {

    private final SpecializationRepository specializationRepository;

    public SpecializationService(SpecializationRepository specializationRepository) {
        this.specializationRepository = specializationRepository;
    }

    public Specialization save(Specialization specialization) {
        return specializationRepository.save(specialization);
    }

    public Specialization update(Specialization specialization) throws SpecializationNotFoundException {
        if (specializationRepository.existsById(specialization.getId())) {
            return specializationRepository.save(specialization);
        } else throw new SpecializationNotFoundException();
    }

    public void delete(Long specializationId) throws SpecializationNotFoundException {
        if (specializationRepository.existsById(specializationId)) {
            specializationRepository.deleteById(specializationId);
        } else throw new SpecializationNotFoundException();
    }

    public List<Specialization> getAll() {
        return specializationRepository.findAll();
    }


}
