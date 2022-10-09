package com.example.soloproject.service;

import com.example.soloproject.entity.User;
import com.example.soloproject.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @DisplayName("1. UserRepsitory ")
    @Test
    void test_1(){

        User user = new User();
        

    }



}