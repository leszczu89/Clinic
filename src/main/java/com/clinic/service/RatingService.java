package com.clinic.service;

import com.clinic.domain.Doctor;
import com.clinic.domain.Patient;
import com.clinic.domain.Rating;
import com.clinic.exceptions.RatingNotFountException;
import com.clinic.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating update(Rating rating) throws RatingNotFountException {
        if (ratingRepository.existsById(rating.getId())) {
            return ratingRepository.save(rating);
        } else throw new RatingNotFountException();
    }

    public void delete(Long ratingId) throws RatingNotFountException {
        if (ratingRepository.existsById(ratingId)) {
            ratingRepository.deleteById(ratingId);
        } else throw new RatingNotFountException();
    }

    public Rating get(Long ratingId) {
        return Optional.of(ratingRepository.findById(ratingId)).get().orElseThrow(RatingNotFountException::new);
    }

    public List<Rating> getByDoctor(Doctor doctor) {
        return ratingRepository.findRatingByDoctor(doctor);
    }

    public List<Rating> getByPatient(Patient patient) {
        return ratingRepository.findRatingByPatient(patient);
    }

}
