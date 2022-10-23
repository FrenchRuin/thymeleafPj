package com.example.soloproject.entity;

import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.repository.AddressRepository;
import com.example.soloproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserEntityTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;


    @Transactional
    @DisplayName("1. FK Test")
    @Test
    void test_1(){
        userRepository.findAll();

        log.info("{}",addressRepository.findAll());
    }


}