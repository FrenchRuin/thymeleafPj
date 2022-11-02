package com.example.soloproject.config;

import com.mysql.cj.PreparedQuery;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig { // WebSecurityConfigurerAdapter is deprecated.



    // Configuring HttpSecurity
//    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // set the login , error, fail situation in this Filter Chain
        return http.csrf().disable().authorizeRequests()
                .antMatchers("/login", "/error").permitAll()
                .antMatchers("/board").hasRole("ADMIN")
                .antMatchers("/user").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .and().build();
    }

    //Configuring WebSecurity
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().antMatchers("/resources/**");
    }

    // Password Encode
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        final PasswordEncoder pw = passwordEncoder();
        UserDetails user1 = User.builder()
                .username("user1")
                .password(pw.encode("1234"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()
                .username("user2")
                .password(pw.encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

}
