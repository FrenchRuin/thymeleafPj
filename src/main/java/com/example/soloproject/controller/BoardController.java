package com.example.soloproject.controller;


import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.dto.UserDto;
import com.example.soloproject.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class BoardController {

    final
    BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public String board(Model model) {
        model.addAttribute("boardList", boardService.findBoard());
        model.addAttribute("boardDto", new BoardDto());
        model.addAttribute("userDto", new UserDto());
        return "board/board";
    }

    @PostMapping("/board/add")
    public String addBoard(UserDto userDto, BoardDto boardDto) {
        boardService.addBoard(boardDto, userDto.getEmail());
        return "redirect:/board";
    }

    @GetMapping("/board/deleteAll")
    public String deleteAllBoard() {
        boardService.deleteAll();
        return "redirect:/board";
    }
}
