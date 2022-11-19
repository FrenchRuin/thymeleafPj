package com.example.soloproject.token;

import com.example.soloproject.dto.UserAccountDto;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

@Component
public class UserManager implements AuthenticationProvider, InitializingBean, AuthenticationManager {

    private HashMap<String, UserAccountDto> userDb = new HashMap<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UserAuthenticationToken token = (UserAuthenticationToken) authentication;
        if (userDb.containsKey(token.getCredentials())) {
            UserAccountDto user = userDb.get(token.getCredentials());
            return UserAuthenticationToken
                    .builder()
                    .principal(user)
                    .details(user.getUsername())
                    .authenticated(true)
                    .build();
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication == UserAuthenticationToken.class;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Set.of(
                new UserAccountDto("lee", "이이사", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new UserAccountDto("kim", "김이사", Set.of(new SimpleGrantedAuthority("ROLE_USER"))),
                new UserAccountDto("gang", "강이사", Set.of(new SimpleGrantedAuthority("ROLE_ADMIN")))
        ).forEach(u -> userDb.put(u.getId(), u));
    }


}
