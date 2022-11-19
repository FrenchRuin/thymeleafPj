package com.example.soloproject.config;

import com.example.soloproject.token.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
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

@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig { // WebSecurityConfigurerAdapter is deprecated.



    private AuthenticationManager authenticationManager;

    final
    UserManager userManager;

    public WebSecurityConfig(UserManager userManager) {
        this.userManager = userManager;
    }

    @Bean
    public void configure(AuthenticationManagerBuilder builder) {
        builder.authenticationProvider(userManager);
    }

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CustomLoginFilter customLoginFilter = new CustomLoginFilter(authenticationManager);
        // set the login , error, fail situation in this Filter Chain
        return http
                .authorizeRequests(
                        request -> {
                            request.antMatchers("/", "/auth", "/login").permitAll()
                                    .anyRequest().authenticated();
                        }
                )
//                .formLogin(
//                        login -> {
//                            login.loginPage("/login")
//                                    .permitAll()
//                                    .defaultSuccessUrl("/", false)
//                                    .failureUrl("/login-error");
//                        }
//                )
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


}
