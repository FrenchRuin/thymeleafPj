package com.example.soloproject.service;

import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.AddressEntity;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.AddressRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @Autowired
    ModelMapperUtils modelMapperUtils;

    @Autowired
    AddressRepository addressRepository;

    @DisplayName("1. address Null Test ")
    @Test
    void test_1(){

        AddressEntity addressEntity = addressRepository.findByUserId("toxic023");

        if (addressEntity == null) {
            log.info("userDto : {}", new UserDto());
        }else{
            AddressDto addressDto = modelMapperUtils.getMapper().map(addressEntity, AddressDto.class);
            log.info("addressDto : {}", addressDto);
        }
    }
}