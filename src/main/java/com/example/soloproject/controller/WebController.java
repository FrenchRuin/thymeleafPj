package com.example.soloproject.controller;


import com.example.soloproject.dto.LoginInfoDto;
import com.example.soloproject.dto.WebDto;
import com.example.soloproject.service.WebService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class WebController {

    @Autowired
    WebService webService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test2(Model model, WebDto webDto) {
        return "index";
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    public String test3(HttpServletRequest request, Model model, WebDto webDto) {
        model.addAttribute("webDto", new WebDto());

        webService.printIn(webDto);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, LoginInfoDto loginInfoDto) {
        return "login";
    }

    @RequestMapping(value = "/saveLogin", method = RequestMethod.POST)
    public String saveLogin(HttpServletRequest request, Model model, LoginInfoDto loginInfoDto) {

        model.addAttribute("loginInfoDto", new LoginInfoDto());

        return webService.printLogin(loginInfoDto);
    }

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board() {
        return "board";
    }
}
