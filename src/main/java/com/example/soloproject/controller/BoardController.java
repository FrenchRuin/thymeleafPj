package com.example.soloproject.controller;


import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.dto.BoardDto;
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

        return "board";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.POST)
    public String addBoard(BoardDto boardDto) {
        boardService.addBoard(boardDto);
        return "redirect:/board";
    }
}
