package com.example.soloproject.config;

import com.example.soloproject.token.UserManager;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig { // WebSecurityConfigurerAdapter is deprecated.

    final
    UserManager userManager;

    public WebSecurityConfig(UserManager userManager) {
        this.userManager = userManager;
    }


    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CustomLoginFilter customLoginFilter = new CustomLoginFilter(userManager);
        // set the login , error, fail situation in this Filter Chain
        return http
                .authorizeRequests(
                        request -> {
                            request.antMatchers("/", "/auth").permitAll()
                                    .anyRequest().authenticated();
                        }
                )
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(new CustomSuccessHandler())
                .failureHandler(new CustomFailureHandler())
                .and()
                .authenticationManager(new UserManager())
                .addFilterAt(customLoginFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> logout.logoutSuccessUrl("/"))
                .build();
    }

    //Configuring WebSecurity
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        // resource web ignore setting.
        return web -> web.ignoring().requestMatchers(
                PathRequest.toStaticResources().atCommonLocations()
        );
    }
    // Password Encode
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
