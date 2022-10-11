package com.example.soloproject.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

    /* model mapper utils */

    private static final ModelMapper mapper = new ModelMapper();

    public static ModelMapper getMapper() {
        return mapper;
    }

}
