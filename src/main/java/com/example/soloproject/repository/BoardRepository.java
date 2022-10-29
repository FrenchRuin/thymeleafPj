package com.example.soloproject.repository;

import com.example.soloproject.dto.BoardDto;
import com.example.soloproject.entity.BoardEntity;
import com.example.soloproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    // Select from UserRepository needs.
    @Query("select b from BoardEntity b join fetch b.user where b.id = b.user.id")
    List<BoardEntity> findUserBoard();
}
