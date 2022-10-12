package com.example.soloproject.controller;

import com.example.soloproject.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;




    @PostMapping("/movie/search")
    @ResponseBody
    public String searchMovie() {
        log.info(movieService.searchMovie());
        return movieService.searchMovie();
    }
}
