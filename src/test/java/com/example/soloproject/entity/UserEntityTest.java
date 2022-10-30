package com.example.soloproject.entity;

import com.example.soloproject.converter.UserConverter;
import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.repository.AddressRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserEntityTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    @Autowired
    ModelMapperUtils modelMapperUtils;


    @Transactional
    @DisplayName("1. FK Test")
    @Test
    void test_1() {

        UserEntity user = new UserEntity();
        user.setUserId("toxci023");


        log.info(user.toString());
    }

    @Transactional
    @DisplayName("2. fetch join test by UserRepository")
    @Test
    void test2() {
        // (all Data Success) //
        List<UserEntity> userEntityList = userRepository.findAll();

        List<UserDto> userDtoList = userEntityList.stream().map(userEntity ->
                modelMapperUtils.getMapper().map(userEntity, UserDto.class)).collect(Collectors.toList());

        log.info("userList : {}", userDtoList);
    }

    @Transactional
    @DisplayName("3. Null point excepiton")
    @Test
    void test3() {
        UserEntity user = new UserEntity();
        user.setUserId("toxic023");

//        userRepository.save(user);

        AddressEntity address = new AddressEntity();

        address.setAddress("서울시");

        user.setAddress(address);

        userRepository.save(user);

        UserEntity user1 = userRepository.findByUserId("toxic023");
        log.info(user1.toString());

    }
}