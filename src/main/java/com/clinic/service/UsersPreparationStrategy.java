package com.clinic.service;

import com.clinic.domain.Users;

import java.util.Random;


public interface UsersPreparationStrategy {

    Users createUser();

    default String generatePassword() {
        Random generator = new Random();
        String string = String.valueOf(generator.nextInt(100)) + String.valueOf(generator.nextInt(50));
        return string;
    }


}
