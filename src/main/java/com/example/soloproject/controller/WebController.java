package com.example.soloproject.controller;


import com.example.soloproject.dto.WebDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class WebController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("webForm", new WebDto());
        log.info("okokoko");
        return "index";
    }





}
