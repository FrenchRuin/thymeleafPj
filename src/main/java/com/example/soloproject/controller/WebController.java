package com.example.soloproject.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {


    @GetMapping("basic")
    public String alert(Model model) {

        Member member = new Member("toxic023@naver.com", "이재찬", 26);

        model.addAttribute("member", member);
        return "basic";
    }

    @Data
    @AllArgsConstructor
    public static class Member{
        private String email;
        private String name;
        private Integer age;

    }

}
