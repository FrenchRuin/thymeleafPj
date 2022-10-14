package com.example.soloproject.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherApi {

    @Value("${spring.weather.encId}")
    private String encId;

    @Value("${spring.weather.decId}")
    private String decId;

    @Value("${spring.weather.url}")
    private String url;



}
