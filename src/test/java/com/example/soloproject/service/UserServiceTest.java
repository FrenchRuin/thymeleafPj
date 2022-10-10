package com.example.soloproject.service;

import com.example.soloproject.entity.User;
import com.example.soloproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @DisplayName("1. createUser ")
    @Test
    void test_1(){

        /* User service & User Repository Relationship check*/
        User user = new User();
        user.setUserId("toxic023");
        user.setName("ㅇㅇㅇㅇ");
        user.setAddress("강서구");

        userRepository.save(user);
        log.info(userService.findAllUser().toString());
    }

}