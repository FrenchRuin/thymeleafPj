package com.example.soloproject.entity;

import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.repository.BoardRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@SpringBootTest
@Slf4j
class BoardEntityTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ModelMapperUtils modelMapperUtils;

    @Transactional
    @DisplayName("1. fetch join test by UserRepository")
    @Test
    void test_1() {
        // (all Data Success) //
        UserEntity userEntityList = userRepository.findUserAddressData("toxic023");

//        List<UserDto> userDtoList = userEntityList.stream().map(userEntity ->
//                modelMapperUtils.getMapper().map(userEntity, UserDto.class)).collect(Collectors.toList());

//        log.info("userList : {}", userDtoList);
    }

    @Transactional
    @DisplayName("2. fetch join test2 by BoardRepository ")
    @Test
    void test_2() {

        //(Fail, need to select in UserRepository)//

        List<BoardEntity> boardEntityList = boardRepository.findUserBoard();

        List<BoardDto> boardDtoList = boardEntityList.stream().map(boardEntity ->
                modelMapperUtils.getMapper().map(boardEntity, BoardDto.class)
        ).collect(Collectors.toList());

        log.info("boards : {}", boardDtoList);
    }


}