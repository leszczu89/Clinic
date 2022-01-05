package com.clinic.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity(name = "Doctors")
public class Doctor {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Email(message = "Email should be valid")
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Column(name = "SURNAME")
    private String surname;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "SPECIALIZATION")
    public Specialization specialization;

    @OneToOne
    public Users user;

    public Doctor() {
    }

    public Doctor(String email, String name, String surname, Specialization specialization) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Doctor doctor = (Doctor) o;

        if (!Objects.equals(id, doctor.id)) return false;
        if (!Objects.equals(email, doctor.email)) return false;
        if (!Objects.equals(name, doctor.name)) return false;
        if (!Objects.equals(surname, doctor.surname)) return false;
        return Objects.equals(specialization, doctor.specialization);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }
}
