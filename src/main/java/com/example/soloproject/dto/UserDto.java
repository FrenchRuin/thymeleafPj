package com.example.soloproject.dto;

import com.example.soloproject.converter.UserRole;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String userId;
    private String name;
    private String number;
    private String birth;
    private String email;
    private UserRole role;
    private AddressDto address;
    private List<BoardDto> boards = new ArrayList<>();

}
