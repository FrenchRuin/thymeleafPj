package com.example.soloproject.controller;


import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board/add", method = RequestMethod.POST)
    public Map<String,Object> addBoard(@RequestParam Map<String,Object> param) {
        return boardService.addBoard(param);
    }
}
