package com.example.soloproject.service;

import com.example.soloproject.api.SearchApi;
import lombok.extern.slf4j.Slf4j;
import ognl.ObjectElementsAccessor;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieService {

    @Autowired
    SearchApi searchApi;

    public ResponseEntity<String> searchMovie(String title) {
        return searchApi.searchMovie(title);
    }


}
