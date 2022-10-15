package com.example.soloproject.controller;


import com.example.soloproject.api.WeatherApi;
import com.example.soloproject.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class WeatherController {

    @Autowired
    WeatherApi weatherApi;

    @Autowired
    WeatherService weatherService;

    @RequestMapping(value = "/weather/search", method = RequestMethod.GET)
    public Map<String, Object> search() {
       return  weatherService.search();
    }
}
