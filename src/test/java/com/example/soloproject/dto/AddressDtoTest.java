package com.example.soloproject.dto;

import com.example.soloproject.entity.AddressEntity;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class AddressDtoTest {

    @Autowired
    ModelMapperUtils modelMapperUtils;


    @DisplayName("1. Mapping Test ")
    @Test
    void test_1(){

        AddressEntity address = new AddressEntity();

        address.setAddress("강서구!");

        UserEntity user = new UserEntity();
        user.setAddress(address);

        user.setName("이재찬");

        UserDto userDto = modelMapperUtils.getMapper().map(user, UserDto.class);

        log.info("user: {} ", userDto.getAddress());
    }

}