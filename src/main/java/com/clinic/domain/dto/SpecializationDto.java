package com.clinic.domain.dto;

public class SpecializationDto {

    private Long id;
    private String name;

    public SpecializationDto() {
    }

    public SpecializationDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
