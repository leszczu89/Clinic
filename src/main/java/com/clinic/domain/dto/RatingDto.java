package com.clinic.domain.dto;

public class RatingDto {

    private int rate;
    private String description;
    private PatientDto patient;
    private DoctorDto doctor;

    public RatingDto(int rate, String description, PatientDto patient, DoctorDto doctor) {
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

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }
}
