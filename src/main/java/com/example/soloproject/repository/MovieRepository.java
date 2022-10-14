package com.example.soloproject.repository;

import com.example.soloproject.dto.MovieDto;
import com.example.soloproject.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Long> {
}
