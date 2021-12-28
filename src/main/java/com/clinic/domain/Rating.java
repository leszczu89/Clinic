package com.clinic.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "RATINGS")
public class Rating {
    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Range(min = 1, max = 10)
    @Column(name = "RATE")
    private int rate;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull
    @JoinColumn(name = "PATIENT")
    @ManyToOne
    private Patient patient;

    @NotNull
    @JoinColumn(name = "DOCTOR")
    @ManyToOne
    private Doctor doctor;


    public Rating() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (rate != rating.rate) return false;
        if (!Objects.equals(id, rating.id)) return false;
        if (!Objects.equals(description, rating.description)) return false;
        if (!Objects.equals(patient, rating.patient)) return false;
        return Objects.equals(doctor, rating.doctor);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + rate;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (doctor != null ? doctor.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
