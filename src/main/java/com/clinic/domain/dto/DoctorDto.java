package com.clinic.domain.dto;

public class DoctorDto {

    private Long id;
    private String email;
    private String name;
    private String surname;
    private SpecializationDto specializationDto;

    public DoctorDto(String email, String name, String surname, SpecializationDto specializationDto) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.specializationDto = specializationDto;
    }

    public DoctorDto() {
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

    public SpecializationDto getSpecializationDto() {
        return specializationDto;
    }

    public void setSpecializationDto(SpecializationDto specializationDto) {
        this.specializationDto = specializationDto;
    }
}
