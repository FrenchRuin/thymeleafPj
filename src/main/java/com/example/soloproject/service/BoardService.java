package com.example.soloproject.service;


import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.entity.BoardEntity;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.BoardRepository;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapperUtils modelMapperUtils;

    public List<BoardDto> findBoard() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        List<BoardDto> boardList = boardEntityList.stream().map(
                boardEntity -> modelMapperUtils.getMapper().map(boardEntity, BoardDto.class)
        ).collect(Collectors.toList());

        return boardList;
    }

    public void addBoard(BoardDto boardDto) {

        log.info(boardDto.toString());
    }

}
