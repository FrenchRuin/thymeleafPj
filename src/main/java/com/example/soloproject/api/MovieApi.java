package com.example.soloproject.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;

@Component
public class MovieApi {

    @Value("${spring.naver.X-Naver-Client-Id}")
    private String clientId;
    @Value("${spring.naver.X-Naver-Client-Secret}")
    private String clientSecret;

    public Map<String,Object> search(String title) {

        URI uri = UriComponentsBuilder
                .fromUriString("https://openapi.naver.com")
                .path("/v1/search/movie.json")
                .queryParam("query", title)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .queryParam("country", "KR")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);

        //Header를 사용
        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .headers(headers)
                .build();

        ResponseEntity<Map<String, Object>> dd = restTemplate.exchange(req, new ParameterizedTypeReference<>() {
        });

        return dd.getBody();
    }
}
