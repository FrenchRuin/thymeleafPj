package com.example.soloproject.api;

import com.example.soloproject.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Slf4j
class MovieApiTest {

    @Autowired
    MovieApi movieApi;


    @DisplayName("1. api Test ")
    @Test
    void test_1() {

        Map<String,Object> dd = movieApi.search("식객");

        List<Object> mm = (List<Object>) dd.get("items");

        MovieDto dto = new MovieDto();




       log.info("class : {}",mm);

    }


}