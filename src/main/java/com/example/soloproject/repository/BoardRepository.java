package com.example.soloproject.repository;

import com.example.soloproject.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    // Select from UserRepository needs.
    @Query("select b from BoardEntity b join b.user")
    List<BoardEntity> findUserBoard();


    @Query("select u.boards from UserEntity u")
    List<BoardEntity> findAllBoard();
}
