package com.clinic.domain.dto;

import com.clinic.domain.Doctor;
import com.clinic.domain.Patient;

public class RatingDto {

    private int rate;
    private String description;
    private Patient patient;
    private Doctor doctor;

    public RatingDto(int rate, String description, Patient patient, Doctor doctor) {
        this.rate = rate;
        this.description = description;
        this.patient = patient;
        this.doctor = doctor;
    }

    public RatingDto() {
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
