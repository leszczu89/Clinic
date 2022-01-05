package com.clinic.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity(name = "APPOINTMENTS")
public class Appointment {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    public Long id;

    @Column(name = "DATE")
    public LocalDate date;

    @Column(name = "TIME")
    public LocalTime time;

    @Column(name = "PAYMENT")
    public boolean paid = false;

    @NotNull
    @JoinColumn(name = "DOCTOR")
    @ManyToOne
    public Doctor doctor;

    @JoinColumn(name = "PATIENT")
    @ManyToOne
    public Patient patient;


    public Appointment() {
    }

    public Appointment(LocalDate date, LocalTime time, Doctor doctor) {
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.paid = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Appointment that = (Appointment) o;

        if (paid != that.paid) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(date, that.date)) return false;
        if (!Objects.equals(doctor, that.doctor)) return false;
        return Objects.equals(patient, that.patient);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (paid ? 1 : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
