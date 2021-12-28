package com.clinic.controller;

import com.clinic.domain.Doctor;
import com.clinic.domain.dto.DoctorDto;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.service.DoctorsService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/v1/doctor")
public class DoctorController {

    private final DoctorsService doctorsService;
    private final ModelMapper mapper;

    public DoctorController(DoctorsService doctorsService, ModelMapper modelMapper) {
        this.doctorsService = doctorsService;
        this.mapper = modelMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto save(@RequestBody DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor savedDoctor = doctorsService.save(doctor);
        return mapToDto(savedDoctor);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public DoctorDto update(@PathVariable Long id, @RequestBody DoctorDto doctorDto) throws UserNotFoundException {
        Doctor doctor = mapToEntity(doctorDto);
        doctor.setId(id);
        Doctor savedDoctor = doctorsService.update(doctor);
        return mapToDto(savedDoctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws UserNotFoundException {
        doctorsService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public DoctorDto get(@PathVariable Long id) throws UserNotFoundException {
        Doctor doctor = doctorsService.get(id);
        return mapToDto(doctor);
    }

    @GetMapping
    public List<DoctorDto> getAll() {
        List<Doctor> doctors = doctorsService.getAll();
        return  doctors.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private DoctorDto mapToDto(Doctor doctor) {
        return mapper.map(doctor, DoctorDto.class);
    }

    private Doctor mapToEntity(DoctorDto doctorDto) {
        return mapper.map(doctorDto, Doctor.class);
    }
}
