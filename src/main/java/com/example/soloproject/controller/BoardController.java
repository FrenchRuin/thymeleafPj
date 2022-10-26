package com.example.soloproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class BoardController {

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board() {
        return "board";
    }

    @RequestMapping(value = "/board/add", method = RequestMethod.POST)
    public void addBoard() {
        log.info("addBoard");
    }
}
