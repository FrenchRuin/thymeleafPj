package com.example.soloproject.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public String movie() {
        return "movie";
    }

    @RequestMapping(value = "/weather", method = RequestMethod.GET)
    public String weather() {
        return "weather";
    }


}
