package com.example.soloproject.controller;


import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board(Model model) {
        model.addAttribute("boardList", boardService.findBoard());
        model.addAttribute("boardDto", new BoardDto());
        model.addAttribute("userDto", new UserDto());
        return "board";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.POST)
    public String addBoard(UserDto userDto, BoardDto boardDto) {
        boardService.addBoard(boardDto, userDto.getUserId());
        return "redirect:/board";
    }

    @RequestMapping(value = "board/deleteAll", method = RequestMethod.GET)
    public String deleteAllBoard() {
        boardService.deleteAll();
        return "redirect:/board";
    }
}
