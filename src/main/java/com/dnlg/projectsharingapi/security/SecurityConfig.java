package com.dnlg.projectsharingapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
    

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.
            
    }
}
