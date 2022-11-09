package com.example.soloproject.controller;


import com.example.soloproject.dto.AccountDto;
import com.example.soloproject.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class MainController {

    final
    MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("userAccount", new AccountDto());
        return "login/login";
    }

    @RequestMapping(value = "/login/process", method = RequestMethod.POST)
    public String loginProcess(AccountDto accountDto) {
        log.info("{}", accountDto);
        mainService.loadUserByUsername(accountDto.getUserId());
        return "login/login";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String signUp(Model model) {
        model.addAttribute("AccountDto", new AccountDto());
        return "login/signUp";
    }

    @RequestMapping(value = "/signUp/process", method = RequestMethod.POST)
    public String signUpProcess(AccountDto accountDto) {
        mainService.signUpProcess(accountDto.getUserId(),accountDto.getPassword());
        return "redirect:/login";
    }
}
