package com.example.soloproject.dto;

import com.example.soloproject.entity.UserEntity;
import lombok.Data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {

    private Long id;
    private String address;
    private String zipCode;
    private String city;
    private String country;
}
