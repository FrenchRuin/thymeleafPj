package com.example.soloproject.repository;

import com.example.soloproject.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserRepositoryTest {


    @Autowired
    UserRepository userRepository;

    @DisplayName("1. ")
    @Test
    void test_1(){

        UserEntity userEntity = new UserEntity();

        userEntity.setUserId("toxic023");
        userEntity.setBirth("190999");
        userEntity.setNumber("ddddd");
        userEntity.setName("ddddddd");
        userRepository.save(userEntity);
        log.info("{}", userEntity);
        UserEntity user = userRepository.findByUserId("toxic023");

//        user.setUserId("dlwocks023");
//        userRepository.save(user);
//        log.info("{}", user);



    }

}