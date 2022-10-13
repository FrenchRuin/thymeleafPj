package com.example.soloproject.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Component
public class SearchApi {

    @Value("${spring.naver.X-Naver-Client-Id}")
    private String clientId;
    @Value("${spring.naver.X-Naver-Client-Secret}")
    private String clientSecret;

    public ResponseEntity<String> searchMovie(String title){

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/movie.json")
                .queryParam("query",title)
                .queryParam("display",10)
                .queryParam("start",1)
                .queryParam("country", "KR")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id",clientId);
        headers.set("X-Naver-Client-Secret",clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Header를 사용
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .headers(headers)
                .build();

        return restTemplate.exchange(req ,String.class);
    }

}
