package com.example.soloproject.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "user")
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private UserDto user;
}
