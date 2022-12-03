package com.example.soloproject.service;

import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {

    final
    PasswordEncoder passwordEncoder;

    final
    ModelMapperUtils modelMapperUtils;

    public MainService(PasswordEncoder passwordEncoder, ModelMapperUtils modelMapperUtils) {
        this.passwordEncoder = passwordEncoder;
        this.modelMapperUtils = modelMapperUtils;
    }


}
