package com.example.soloproject.dto;

import lombok.Getter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebDto {

    private String name;
    private int age;
    private String address;
}
