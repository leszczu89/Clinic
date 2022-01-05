package com.clinic.service;

import com.clinic.domain.Doctor;
import com.clinic.domain.Role;
import com.clinic.domain.Users;

public class DoctorUserPreparator implements UsersPreparationStrategy {

    private final Doctor doctor;

    public DoctorUserPreparator(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public Users createUser() {
        return new Users(Role.DOCTOR, doctor.getEmail(), generatePassword());
    }
}
