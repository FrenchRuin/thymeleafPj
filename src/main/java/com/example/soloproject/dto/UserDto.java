package com.example.soloproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String user_id;
    private String name;
    private String address1;
    private String address2;
    private String number;
    private String birth;
    private String password;
    private String email;
}
