package com.example.soloproject.service;

import com.example.soloproject.api.SearchApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieService {

    @Autowired
    SearchApi searchApi;

    public String searchMovie() {
        ResponseEntity<String> responseEntity = searchApi.searchMovie();

        return responseEntity.getBody();
    }


}
