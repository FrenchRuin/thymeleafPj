package com.example.soloproject.repository;

import com.example.soloproject.entity.BoardEntity;
import com.example.soloproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserId(String userId);

    // JPQL fetch join
    @Query("select distinct u from UserEntity u join fetch u.boards join fetch u.address")
    List<UserEntity> findAllData();

    @Query("select distinct u from UserEntity u join fetch u.boards")
    List<UserEntity> findUserAddressData();

}
