package com.example.soloproject.controller;

import com.example.soloproject.api.MovieApi;
import com.example.soloproject.dto.MovieDto;
import com.example.soloproject.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    MovieApi movieApi;

    @PostMapping("/movie/search")
    public Map<String, Object> searchMovie(@RequestParam("title") String title) {
        return movieApi.search(title);
    }
}
