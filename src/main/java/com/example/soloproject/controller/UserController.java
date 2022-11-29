package com.example.soloproject.controller;

/*
 view >/DTO/ controller >/DTO/ service >/ENTITY/ repository >/ENTITY/ db
 */


import com.example.soloproject.dto.UserDto;
import com.example.soloproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("userData", userService.findAllUser());
        model.addAttribute("userDto", new UserDto());
        return "user/user";
    }

    @PostMapping("/user/add")
    public String addUser(UserDto userDto) {
        userService.addUser(userDto);
        return "redirect:/user";
    }

    @GetMapping("/user/deleteAll")
    public String deleteAllUser() {
        userService.deleteAllUser();
        return "redirect:/user";
    }

    @GetMapping("/user/detail")
    public String userDetail(@RequestParam("userId") String userId,UserDto userDto, Model model) {
        model.addAttribute("userDto", userService.findUser(userId));
        return "user/userDetail";
    }

    @PostMapping("/user/detailSave")
    public String userDetailSave(@RequestParam("userId") String userId,UserDto userDto, RedirectAttributes redirectAttributes) {
        userService.addUser(userDto);
        redirectAttributes.addAttribute("userId", userId);
        return "redirect:/user/detail";
    }
}
