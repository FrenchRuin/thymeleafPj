package com.example.soloproject.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperUtils {

    /* model mapper utils */

    private static final ModelMapper mapper = new ModelMapper();

    public  ModelMapper getMapper() {
        return mapper;
    }

}
