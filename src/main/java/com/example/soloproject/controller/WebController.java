package com.example.soloproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("basic")
    public String alert(Model model) {
        model.addAttribute("Name", "이름");
        return "thymeleaf";
    }




}
