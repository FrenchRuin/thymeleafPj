package com.example.soloproject.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;

@SpringBootTest
@Slf4j
class WeatherApiTest {

    @Autowired
    WeatherApi weatherApi;

    @DisplayName("1. ")
    @Test
    void test_1() {

        ResponseEntity<Map<String,Object>> response = weatherApi.search();

        Map<String,Object> list = response.getBody();

        log.info("Map : {} ", list);


    }

}