package com.example.soloproject.utils;

import org.modelmapper.ModelMapper;

public class ModelMapperUtils {

    private static final ModelMapper mapper = new ModelMapper();

    public static ModelMapper getMapper() {
        return mapper;
    }

}
