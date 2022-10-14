package com.example.soloproject.service;

import com.example.soloproject.api.MovieApi;
import com.example.soloproject.dto.MovieDto;
import com.example.soloproject.entity.MovieEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class MovieService {

    @Autowired
    MovieApi movieApi;


    public MovieDto entityToDto(MovieEntity entity) {

        return MovieDto
                .builder()
                .actor(entity.getActor())
                .director(entity.getDirector())
                .image(entity.getImage())
                .link(entity.getLink())
                .pubDate(entity.getPubDate())
                .subTitle(entity.getSubTitle())
                .title(entity.getTitle())
                .userRating(entity.getUserRating())
                .build();
    }

    public MovieEntity dtoToEntity(MovieDto dto) {

        return MovieEntity
                .builder()
                .actor(dto.getActor())
                .director(dto.getDirector())
                .image(dto.getImage())
                .link(dto.getLink())
                .pubDate(dto.getPubDate())
                .subTitle(dto.getSubTitle())
                .title(dto.getTitle())
                .userRating(dto.getUserRating())
                .build();
    }


}
