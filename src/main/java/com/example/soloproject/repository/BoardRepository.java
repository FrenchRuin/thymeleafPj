package com.example.soloproject.repository;

import com.example.soloproject.dto.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardDto, Long> {

}
