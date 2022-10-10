package com.example.soloproject.controller;


import com.example.soloproject.entity.User;
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
    public String board(Model model, User user) {
        model.addAttribute("users", userService.findAllUser());
        return "board";
    }

    @RequestMapping(value = "/addBoard", method = RequestMethod.POST)
    public String addBoard(Model model, User user) {
        model.addAttribute("user", new User());

        userService.createUser(user);

        return "redirect:/board";
    }

    @RequestMapping(value = "/deleteBoard", method = RequestMethod.DELETE)
    public String deleteBoard(Model model, User user) {

        userRepository.deleteById(user.getId());

        return "redirect:/board";
    }
}
