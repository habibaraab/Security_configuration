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
        UserDetails habiba = User.builder()
                .username("habiba")
                .password("{noop}123")
                .roles("ADMIN")
                .build();
        UserDetails bia = User.builder()
                .username("bia")
                .password("{noop}123")
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(habiba, bia);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/user/**", "/api/v1/role/**",  "/swagger-ui.html").authenticated()
                        .requestMatchers("/api/role/admin").hasRole("ADMIN")
                        .requestMatchers("/api/role/user").hasRole("USER")
                        .anyRequest().permitAll())
                .httpBasic(withDefaults());
        return http.build();
    }
}
