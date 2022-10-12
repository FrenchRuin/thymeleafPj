package com.example.soloproject.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@Slf4j
class MovieSearchApiTest {


    @DisplayName("1. api Test ")
    @Test
    void test_1() {

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/movie.json")
                .queryParam("query","식객")
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("country", "KR")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        //Header를 사용
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .header("X-Naver-Client-Id", "0QJhbYw2IhHIs78ihpxV")
                .header("X-Naver-Client-Secret", "LSz5CRvuF4")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req,String.class);

        log.info(result.getBody());
    }


}