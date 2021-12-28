package com.clinic.controller;

import com.clinic.domain.Doctor;
import com.clinic.domain.Patient;
import com.clinic.domain.Rating;
import com.clinic.domain.dto.RatingDto;
import com.clinic.exceptions.RatingNotFountException;
import com.clinic.service.RatingService;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/rating")
public class RatingController {

    private final RatingService ratingService;
    private final ModelMapper mapper;

    public RatingController(RatingService ratingService, ModelMapper mapper) {
        this.ratingService = ratingService;
        this.mapper = mapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public RatingDto save(@RequestBody RatingDto ratingDto) {
        Rating rating = mapToEntity(ratingDto);
        Rating savedRating = ratingService.save(rating);
        return mapToDto(savedRating);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RatingDto update(@PathVariable Long id, @RequestBody RatingDto ratingDto) throws RatingNotFountException {
        Rating rating = mapToEntity(ratingDto);
        rating.setId(id);
        Rating savedRating = ratingService.update(rating);
        return mapToDto(savedRating);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws RatingNotFountException {
        ratingService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public RatingDto get(@PathVariable Long id) throws RatingNotFountException {
        Rating rating = ratingService.get(id);
        return mapToDto(rating);
    }

    @GetMapping
    public List<RatingDto> getByDoctor(Doctor doctor) {
        List<Rating> ratings = ratingService.getByDoctor(doctor);
        return  ratings.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @GetMapping
    public List<RatingDto> getByPatient(Patient patient) {
        List<Rating> ratings = ratingService.getByPatient(patient);
        return  ratings.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private RatingDto mapToDto(Rating rating) {
        return mapper.map(rating, RatingDto.class);
    }

    private Rating mapToEntity(RatingDto ratingDto) {
        return mapper.map(ratingDto, Rating.class);
    }

}
