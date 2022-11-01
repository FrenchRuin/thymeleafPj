package com.example.soloproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {



    // WebSecurityConfigurerAdapter is deprecated.
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.formLogin().disable();
        return http.build();
    }

}
