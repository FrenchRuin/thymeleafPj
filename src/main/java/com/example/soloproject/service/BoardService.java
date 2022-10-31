package com.example.soloproject.service;


import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.dto.UserDto;
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
        List<BoardEntity> boardEntityList = boardRepository.findAllBoard();

        List<BoardDto> boardList = boardEntityList.stream().map(
                boardEntity -> modelMapperUtils.getMapper().map(boardEntity, BoardDto.class)
        ).collect(Collectors.toList());

        return boardList;
    }

    public void addBoard(BoardDto boardDto, String userId) {
//        log.info(boardDto.toString());
//        log.info(userId);
        UserEntity user = userRepository.findUserAddressData(userId);
        if (user == null) {
            return;
        }
        BoardEntity boardEntity = modelMapperUtils.getMapper().map(boardDto, BoardEntity.class);

        boardEntity.setUser(user);

        boardRepository.save(boardEntity);
    }

    public void deleteAll() {
        boardRepository.deleteAll();
    }

}
