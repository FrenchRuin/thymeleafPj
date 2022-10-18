package com.example.soloproject.repository;

import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

}
