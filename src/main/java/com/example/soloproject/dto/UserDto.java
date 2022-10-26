package com.example.soloproject.dto;

import com.example.soloproject.entity.AddressEntity;
import com.example.soloproject.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String userId;
    private String name;
    private String number;
    private String birth;
    private String email;
    private AddressDto address;
    private List<BoardDto> boards;

}
