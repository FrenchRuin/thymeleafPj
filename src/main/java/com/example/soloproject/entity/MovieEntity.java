package com.example.soloproject.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MovieEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String actor;
    private String director;
    private String image;
    private String link;
    private String pubDate;
    private String subTitle;
    private String title;
    private String userRating;

}
