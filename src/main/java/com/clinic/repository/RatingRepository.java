package com.clinic.repository;

import com.clinic.domain.Doctor;
import com.clinic.domain.Patient;
import com.clinic.domain.Rating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, Long> {

    @Override
    Rating save(Rating rating);

    List<Rating> findRatingByDoctor(Doctor doctor);

    List<Rating> findRatingByPatient(Patient patient);
}
