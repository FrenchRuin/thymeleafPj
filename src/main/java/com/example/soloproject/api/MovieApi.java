package com.example.soloproject.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Component
public class MovieApi {

    @Value("${spring.naver.X-Naver-Client-Id}")
    private String clientId;
    @Value("${spring.naver.X-Naver-Client-Secret}")
    private String clientSecret;

    public ResponseEntity<String> searchMovie(){

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
                .header("X-Naver-Client-Id", clientId)
                .header("X-Naver-Client-Secret", clientSecret)
                .build();

        return restTemplate.exchange(req,String.class);
    }

}
