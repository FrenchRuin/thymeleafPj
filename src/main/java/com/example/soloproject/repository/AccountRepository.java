package com.example.soloproject.repository;

import com.example.soloproject.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

    AccountEntity findByUserId(String userId);
}
