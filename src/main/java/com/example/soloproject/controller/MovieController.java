package com.example.soloproject.controller;

import com.example.soloproject.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public String movie() {
        return "movie";
    }

    @PostMapping("/movie/search")
    @ResponseBody
    public ResponseEntity<String> searchMovie() {
        return movieService.searchMovie();
    }
}
