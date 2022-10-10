package com.example.soloproject.service;

import com.example.soloproject.entity.User;
import com.example.soloproject.repository.UserRepository;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @DisplayName("1. UserRepsitory ")
    @Test
    void test_1(){

        User user = new User();
        user.setUserId("toxic023");
        user.setName("ㅇㅇㅇㅇ");
        user.setAddress("강서구");

        userRepository.save(user);

    }

}