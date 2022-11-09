package com.example.soloproject.converter;

import com.example.soloproject.entity.AccountEntity;
import lombok.Getter;
import org.springframework.security.core.userdetails.User;

@Getter
public class AccountConverter extends User {

    private AccountEntity account;

    public AccountConverter(AccountEntity account) {
        super(account.getUsername(), account.getPassword(), account.getAuthorities());
    }

}
