package com.clinic.service;

import com.clinic.domain.Doctor;
import com.clinic.domain.Users;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorsService {

    private final DoctorRepository doctorRepository;
    private final UserService userService;

    public DoctorsService(DoctorRepository doctorRepository, UserService userService) {
        this.doctorRepository = doctorRepository;
        this.userService = userService;
    }

    public Doctor save(Doctor doctor) {
        UsersPreparationStrategy usersPreparationStrategy = new DoctorUserPreparator(doctor);
        Users users = usersPreparationStrategy.createUser();
        Users savedUser = userService.save(users);
        doctor.setUser(savedUser);
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
