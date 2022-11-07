package com.example.soloproject.service;

import com.example.soloproject.converter.UserRole;
import com.example.soloproject.dto.AddressDto;
import com.example.soloproject.entity.AccountEntity;
import com.example.soloproject.entity.AddressEntity;
import com.example.soloproject.repository.AccountRepository;
import com.example.soloproject.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {

    final
    AccountRepository accountRepository;

    final
    PasswordEncoder passwordEncoder;

    public MainService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signUpProcess(String id,String password){

        // only ROLE_USER part // needs to update Admin accept

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setUserId(id);
        accountEntity.setPassword(passwordEncoder.encode(password));
        accountEntity.setRole(UserRole.ROLE_USER);

        accountRepository.save(accountEntity);

        log.info("Information : {}", accountEntity);
    }
}
