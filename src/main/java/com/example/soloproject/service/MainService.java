package com.example.soloproject.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {


    public void signUpProcessing(String id,String password){
        log.info("Information : {}, {}", id, password);
    }
}
