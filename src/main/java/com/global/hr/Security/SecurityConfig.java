package com.global.hr.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails hanaz = User.builder()
                .username("hanaz")
                .password("{noop}123")
                .roles("ADMIN")
                .build();
        UserDetails yara = User.builder()
                .username("yara")
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(hanaz, yara);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/user/**", "/api/v1/role/**").authenticated()
                        .requestMatchers("/api/role/admin").hasRole("ADMIN")
                        .requestMatchers("/api/role/user").hasRole("USER")
                        .anyRequest().permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }
}
