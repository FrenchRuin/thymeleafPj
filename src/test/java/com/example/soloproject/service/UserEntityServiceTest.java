package com.example.soloproject.service;

import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class UserEntityServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @DisplayName("1. createUser ")
    @Test
    void test_1(){

        /* User service & User Repository Relationship check*/
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("toxic023");
        userEntity.setName("ㅇㅇㅇㅇ");
        userEntity.setAddress("강서구");

        userRepository.save(userEntity);
        log.info(userService.findAllUser().toString());
    }

    @DisplayName("2. modelMapperTest")
    @Test
    void test_2(){
       /* model mapper (dto to entity) connection */
       UserDto userDto = new UserDto();
       userDto.setUserId("toxic023");
       userDto.setAddress("toxic023");
       userDto.setName("toxic023");
       userDto.setId(1L);

        ModelMapper modelMapper = new ModelMapper();
        UserEntity entity = modelMapper.map(userDto, UserEntity.class);

        log.info("userId : {}",entity.getUserId());
        log.info("address : {}",entity.getAddress());
        log.info("name : {}",entity.getName());
        log.info("id : {}",entity.getId().toString());
    }


}