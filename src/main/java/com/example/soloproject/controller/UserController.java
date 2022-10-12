package com.example.soloproject.controller;

/*
 view >/DTO/ controller >/DTO/ service >/ENTITY/ repository >/ENTITY/ db
 *
 */


import com.example.soloproject.dto.UserDto;
import com.example.soloproject.entity.UserEntity;
import com.example.soloproject.repository.UserRepository;
import com.example.soloproject.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public String board(Model model, UserDto userDto) {
        model.addAttribute("users", userService.findAllUser());
        return "board";
    }

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public String addBoard(Model model, UserDto userDto) {

        model.addAttribute("userDto", new UserDto());

        userService.createUser(userDto);

        return "redirect:/board";
    }

    @RequestMapping(value = "/deleteBoard")
    public String deleteBoard() {

       userService.deleteUser();

        return "redirect:/board";
    }
}
