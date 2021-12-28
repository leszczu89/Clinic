package com.clinic.service;

import com.clinic.domain.Users;
import com.clinic.exceptions.UserNotFoundException;
import com.clinic.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users save(Users user) {
        return userRepository.save(user);
    }

    public Users update(Users user) throws UserNotFoundException {
        if (userRepository.existsById(user.getId())) {
           return userRepository.save(user);
        } else throw new UserNotFoundException();
    }

    public void delete(Long usersId) throws UserNotFoundException {
        if (userRepository.existsById(usersId)) {
            userRepository.deleteById(usersId);
        } else throw new UserNotFoundException();
    }

    public Users get(Long usersId) throws UserNotFoundException {
        return Optional.of(userRepository.findById(usersId)).get().orElseThrow(UserNotFoundException::new);
    }


}
