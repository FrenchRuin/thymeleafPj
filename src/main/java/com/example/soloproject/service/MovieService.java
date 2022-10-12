package com.example.soloproject.service;

import com.example.soloproject.api.MovieApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieApi movieApi;

    public String searchMovie() {
        ResponseEntity<String> responseEntity = movieApi.searchMovie();
        return responseEntity.getBody();
    }


}
