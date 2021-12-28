package com.clinic.service;

import com.clinic.domain.Doctor;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    private final DoctorRepository doctorRepository;

    public DoctorsService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor update(Doctor doctor) throws UserNotFoundException {
        if (doctorRepository.existsById(doctor.getId())) {
            return doctorRepository.save(doctor);
        } else throw new UserNotFoundException();
    }

    public void delete(Long doctorId) throws UserNotFoundException {
        if (doctorRepository.existsById(doctorId)) {
            doctorRepository.deleteById(doctorId);
        } else throw new UserNotFoundException();
    }

    public Doctor get(Long doctorId) throws UserNotFoundException {
        return Optional.of(doctorRepository.findById(doctorId)).get().orElseThrow(UserNotFoundException::new);
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }
}
