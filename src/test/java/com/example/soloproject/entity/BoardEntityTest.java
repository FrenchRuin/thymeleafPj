package com.example.soloproject.entity;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class BoardEntityTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapperUtils modelMapperUtils;

    @Transactional
    @DisplayName("1. ")
    @Test
    void test_1(){
        UserEntity user = userRepository.findByUserId("toxic023");

        UserDto userDto = modelMapperUtils.getMapper().map(user, UserDto.class);

        log.info(userDto.toString());

    }

}