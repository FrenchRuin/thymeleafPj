package com.example.soloproject.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class WeatherApiTest {

    @Value("${spring.weather.encId}")
    private String encId;

    @Value("${spring.weather.decId}")
    private String decId;

    @Value("${spring.weather.url}")
    private String url;

    @DisplayName("1. ")
    @Test
    void test_1(){

    }

}