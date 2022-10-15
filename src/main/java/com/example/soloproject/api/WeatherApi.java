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
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Component
public class WeatherApi {

    @Value("${spring.weather.encId}")
    private String encId;

    @Value("${spring.weather.decId}")
    private String decId;

    @Value("${spring.weather.url}")
    private String url;


    public ResponseEntity<Map<String,Object>> search() {
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .queryParam("serviceKey", encId)
                .queryParam("pageNo", "1")
                .queryParam("numOfRows", "10")
                .queryParam("dataType", "JSON")
                .queryParam("base_date", "20221015")
                .queryParam("base_time", "0600")
                .queryParam("nx", "123")
                .queryParam("ny", "23")
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .headers(headers)
                .build();

        ResponseEntity<Map<String,Object>> response = restTemplate
                .exchange(req, new ParameterizedTypeReference<Map<String, Object>>() {
                });

        return response;
    }


}
