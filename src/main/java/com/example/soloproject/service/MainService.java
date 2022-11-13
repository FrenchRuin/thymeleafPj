package com.example.soloproject.service;

import com.example.soloproject.converter.AccountConverter;
import com.example.soloproject.converter.UserRole;
import com.example.soloproject.entity.AccountEntity;
import com.example.soloproject.repository.AccountRepository;
import com.example.soloproject.utils.ModelMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MainService {

    final
    AccountRepository accountRepository;

    final
    PasswordEncoder passwordEncoder;

    final
    ModelMapperUtils modelMapperUtils;

    public MainService(AccountRepository accountRepository, PasswordEncoder passwordEncoder, ModelMapperUtils modelMapperUtils) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapperUtils = modelMapperUtils;
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



//    @Override
//    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
//        AccountEntity account = accountRepository.findByUserId(userId);
//        if (account == null) throw new UsernameNotFoundException("존재하지 않는 정보입니다.");
//        return new AccountConverter(account);
//    }


}
