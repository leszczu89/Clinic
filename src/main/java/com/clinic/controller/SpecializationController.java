package com.clinic.controller;

import com.clinic.domain.Specialization;
import com.clinic.domain.dto.SpecializationDto;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.service.SpecializationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/specialization")
public class SpecializationController {

    private final SpecializationService specializationService;
    private final ModelMapper mapper;

    public SpecializationController(SpecializationService specializationService, ModelMapper mapper) {
        this.specializationService = specializationService;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpecializationDto save(@RequestBody SpecializationDto specializationDto) {
        Specialization specialization = mapToEntity(specializationDto);
        Specialization savedSpecialization = specializationService.save(specialization);
        return mapToDto(savedSpecialization);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public SpecializationDto update(@PathVariable Long id, @RequestBody SpecializationDto specializationDto) throws UserNotFoundException {
        Specialization specialization = mapToEntity(specializationDto);
        specialization.setId(id);
        Specialization savedSpecialization = specializationService.update(specialization);
        return mapToDto(savedSpecialization);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws UserNotFoundException {
        specializationService.delete(id);
    }

 /*   @GetMapping(value = "/{id}")
    public SpecializationDto get(@PathVariable Long id) throws UserNotFoundException {
        Specialization specialization = specializationService.get(id);
        return mapToDto(specialization);
    }*/

    @GetMapping
    public List<SpecializationDto> getAll() {
        List<Specialization> specializations = specializationService.getAll();
        return  specializations.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private SpecializationDto mapToDto(Specialization specialization) {
        return mapper.map(specialization, SpecializationDto.class);
    }

    private Specialization mapToEntity(SpecializationDto specializationDto) {
        return mapper.map(specializationDto, Specialization.class);
    }
}
