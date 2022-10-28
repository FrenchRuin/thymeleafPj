package com.example.soloproject.service;

import com.example.soloproject.entity.BoardEntity;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.BoardRepository;
import com.example.soloproject.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class BoardServiceTest {


    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardService boardService;

    @Transactional
    @DisplayName("1. Find User Data in Board ")
    @Test
    void test_1(){

        List<UserEntity> userEntity = userRepository.findAll();

        log.info(userEntity.toString());

//        Optional<BoardEntity> boards = boardRepository.findById(3L);
//
//        log.info("boards : {}", boards);


    }

}