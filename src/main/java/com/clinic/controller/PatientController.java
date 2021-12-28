package com.clinic.controller;

import com.clinic.domain.Patient;
import com.clinic.domain.dto.PatientDto;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/patient")
public class PatientController {

    private final PatientService patientService;
    private final ModelMapper mapper;

    public PatientController(PatientService patientService, ModelMapper mapper) {
        this.patientService = patientService;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientDto save(@RequestBody PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient savedPatient = patientService.save(patient);
        return mapToDto(savedPatient);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientDto update(@PathVariable Long id, @RequestBody PatientDto patientDto) throws UserNotFoundException {
        Patient patient = mapToEntity(patientDto);
        patient.setId(id);
        Patient savedPatient = patientService.update(patient);
        return mapToDto(savedPatient);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws UserNotFoundException {
        patientService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public PatientDto get(@PathVariable Long id) throws UserNotFoundException {
        Patient patient = patientService.get(id);
        return mapToDto(patient);
    }

    @GetMapping
    public List<PatientDto> getAll() {
        List<Patient> patients = patientService.getAll();
        return  patients.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private PatientDto mapToDto(Patient patient) {
        return mapper.map(patient, PatientDto.class);
    }

    private Patient mapToEntity(PatientDto patientDto) {
        return mapper.map(patientDto, Patient.class);
    }
}
