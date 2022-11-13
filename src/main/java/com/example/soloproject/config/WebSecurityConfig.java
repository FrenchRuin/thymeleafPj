package com.example.soloproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig { // WebSecurityConfigurerAdapter is deprecated.


    // Resource file not apply security.
//    @Bean
//    @Order(0)
//    SecurityFilterChain resources(HttpSecurity http) throws Exception {
//        http
//                .requestMatchers((matchers) -> matchers.antMatchers("/templates/**"))
//                .authorizeHttpRequests((authorize) -> authorize.anyRequest().permitAll())
//                .requestCache().disable()
//                .securityContext().disable()
//                .sessionManagement().disable();
//
//        return http.build();
//    }

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // set the login , error, fail situation in this Filter Chain
        return http
                .authorizeRequests(
                        request -> {
                            request.antMatchers("/","/auth").permitAll()
                                    .anyRequest().hasAnyRole("USER","ADMIN");
                        }
                )
                .formLogin(
                        login -> {
                            login.loginPage("/login")
                                    .permitAll()
                                    .defaultSuccessUrl("/", false)
                                    .failureUrl("/login-error");
                        }
                ).build();
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

    // Inmemory user
    @Bean
    public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
                .password(bCryptPasswordEncoder.encode("1111"))
                .roles("USER").build());
        manager.createUser(User.withUsername("admin")
                .password(bCryptPasswordEncoder.encode("2222"))
                .roles("ADMIN").build());

        return manager;
    }



    // Inmemory UserDetail Service deprecated.
//    @Bean
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser(
//                        User.withDefaultPasswordEncoder()
//                                .username("user1")
//                                .password(passwordEncoder().encode("1111"))
//                                .roles("USER")
//                ).withUser(
//                        User.withDefaultPasswordEncoder()
//                                .username("admin")
//                                .password(passwordEncoder().encode("2222"))
//                                .roles("ADMIN")
//                );
//    }

}
