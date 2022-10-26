package com.example.soloproject.service;

import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.AddressEntity;
import com.example.soloproject.entity.BoardEntity;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.AddressRepository;
import com.example.soloproject.repository.BoardRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    @DisplayName("1. address Null Test ")
    @Test
    void test_1(){

        UserDto userDto = new UserDto();

        AddressDto addressDto = new AddressDto();
        addressDto.setAddress("서울시 강서구");

        userDto.setAddress(addressDto);

        UserEntity userEntity = modelMapperUtils.getMapper().map(userDto, UserEntity.class);

        userRepository.save(userEntity);
    }

    @Transactional
    @DisplayName("2. Board Test ")
    @Test
    void test_2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUserId("toxic023");

        userRepository.save(userEntity);
        log.info(userEntity.toString());

        BoardEntity boardEntity = new BoardEntity();

        boardEntity.setContent("그래그래");
        boardEntity.setUser(userEntity);

        boardRepository.save(boardEntity);
        log.info(boardEntity.toString());
    }


}