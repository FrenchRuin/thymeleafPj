package com.example.soloproject.service;

import com.example.soloproject.api.MovieApi;
import com.example.soloproject.api.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class WeatherService {

    @Autowired
    WeatherApi weatherApi;

    public Map<String,Object> search() {
        return  weatherApi.search().getBody();
    }

}
