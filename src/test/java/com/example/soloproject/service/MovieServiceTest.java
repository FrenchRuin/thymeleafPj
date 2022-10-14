package com.example.soloproject.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class MovieServiceTest {

    @Autowired
    MovieService movieService;
    @Value("${spring.naver.X-Naver-Client-Id}")
    private String clientId;
    @Value("${spring.naver.X-Naver-Client-Secret}")
    private String clientSecret;

    @DisplayName("1. Movie Service Test ")
    @Test
    void test_1(){
      List<Map<String,Object>>  dd = (List<Map<String, Object>>) movieService.searchMovie("공공의적").get("items");

      log.info(dd.toString());

    }
}