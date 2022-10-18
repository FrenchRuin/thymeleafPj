package com.example.soloproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

    @RequestMapping(value = "/board",method = RequestMethod.GET)
    public String board() {
        return "board";
    }

}
