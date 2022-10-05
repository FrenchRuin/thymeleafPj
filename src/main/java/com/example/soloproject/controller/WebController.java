package com.example.soloproject.controller;


import com.example.soloproject.dto.WebDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class WebController {

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("webForm", new WebDto());
        log.info("okokoko");
        return "index";
    }

    @RequestMapping(value = "test2", method = RequestMethod.GET)
    public String test2(Model model, WebDto webDto) {
        webDto.setAddress("ddddd");
        webDto.setName("ddddd");
        return "index";
    }

    @RequestMapping(value = "test3", method = RequestMethod.POST)
    public String test3(HttpServletRequest request, Model model, WebDto webDto) {
        model.addAttribute("webDto", new WebDto());
        log.info(webDto.getName());
        log.info(webDto.getAddress());
        return "redirect:/test2";
    }

    @RequestMapping(value = "test4", method = RequestMethod.GET)
    public String test4(Model model, WebDto webDto) {
        WebDto webDto1 = new WebDto();
        return "index";
    }
}
