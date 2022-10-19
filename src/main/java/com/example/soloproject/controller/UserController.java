package com.example.soloproject.controller;

/*
 view >/DTO/ controller >/DTO/ service >/ENTITY/ repository >/ENTITY/ db
 */


import com.example.soloproject.dto.UserDto;
import com.example.soloproject.service.UserService;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model, UserDto userDto) {
        model.addAttribute("userList", userService.findAllUser());
        return "user";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/deleteAll", method = RequestMethod.GET)
    public String deleteAllUser() {
        userService.deleteAllUser();
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/detail", method = RequestMethod.GET)
    public String userDetail(@RequestParam("userId") String userId, Model model) {
        userService.findUserDetail(userId);
        return "userDetail";
    }


}
