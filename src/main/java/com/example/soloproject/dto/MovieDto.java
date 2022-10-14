package com.example.soloproject.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDto {

    private String actor;
    private String director;
    private String image;
    private String link;
    private String pubDate;
    private String subTitle;
    private String title;
    private String userRating;

}
