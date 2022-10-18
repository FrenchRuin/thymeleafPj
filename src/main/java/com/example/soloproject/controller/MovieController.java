package com.example.soloproject.controller;

import com.example.soloproject.api.MovieApi;
import com.example.soloproject.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieApi movieApi;

    @RequestMapping(value = "/movie/search",method = RequestMethod.GET)
    public Map<String, Object> searchMovie(@RequestParam("title") String title) {
        log.info(title);
        return movieApi.search(title);
    }
}
