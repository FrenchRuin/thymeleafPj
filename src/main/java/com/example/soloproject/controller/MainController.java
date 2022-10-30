package com.example.soloproject.controller;


import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class MainController {

    @Autowired
    BoardService boardService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }


}
