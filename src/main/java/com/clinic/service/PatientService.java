package com.clinic.service;

import com.clinic.domain.Patient;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient update(Patient patient) throws UserNotFoundException {
        if (patientRepository.existsById(patient.getId())) {
            return patientRepository.save(patient);
        } else throw new UserNotFoundException();
    }

    public void delete(Long patientId) throws UserNotFoundException {
        if (patientRepository.existsById(patientId)) {
            patientRepository.deleteById(patientId);
        } else throw new UserNotFoundException();
    }

    public Patient get(Long patientId) throws UserNotFoundException {
        return Optional.of(patientRepository.findById(patientId)).get().orElseThrow(UserNotFoundException::new);
    }

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
