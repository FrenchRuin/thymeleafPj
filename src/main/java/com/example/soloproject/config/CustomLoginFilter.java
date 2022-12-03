package com.example.soloproject.config;

import com.example.soloproject.token.UserAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class CustomLoginFilter extends UsernamePasswordAuthenticationFilter {


    public CustomLoginFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        username = (username != null) ? username.trim() : "";
        String password = obtainPassword(request);
        password = (password != null) ? password : "";

        UserAuthenticationToken token = UserAuthenticationToken.builder()
                .credentials(username)
                .build();
        return this.getAuthenticationManager().authenticate(token);
    }

}
