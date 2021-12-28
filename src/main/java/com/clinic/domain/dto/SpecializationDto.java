package com.clinic.domain.dto;

public class SpecializationDto {

    private String name;

    public SpecializationDto() {
    }

    public SpecializationDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
