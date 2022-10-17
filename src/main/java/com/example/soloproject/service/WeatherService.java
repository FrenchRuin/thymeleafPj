package com.example.soloproject.service;

import com.example.soloproject.api.MovieApi;
import com.example.soloproject.api.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class WeatherService {

    @Autowired
    WeatherApi weatherApi;

    public List<Object> search() throws IOException {
        Map<String, Object> weatherMap = weatherApi.search();

        /* find temperature value */
        Map<String, Object> response = (Map<String, Object>) weatherMap.get("response");
        Map<String, Object> body = (Map<String, Object>) response.get("body");
        Map<String, Object> items = (Map<String, Object>) body.get("items");

        return  (List<Object>) items.get("item");
    }

}
