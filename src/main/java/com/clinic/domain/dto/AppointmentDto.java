package com.clinic.domain.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDto {

    private Long id;
    private LocalDate date;
    private LocalTime time;
    private boolean paid;
    private DoctorDto doctor;
    private PatientDto patient;

    public AppointmentDto(LocalDate date, LocalTime time, boolean paid, DoctorDto doctor, PatientDto patient) {
        this.date = date;
        this.time = time;
        this.paid = paid;
        this.doctor = doctor;
        this.patient = patient;
    }

    public AppointmentDto() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public DoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorDto doctor) {
        this.doctor = doctor;
    }

    public PatientDto getPatient() {
        return patient;
    }

    public void setPatient(PatientDto patient) {
        this.patient = patient;
    }
}
