package com.dnlg.projectsharingapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        // DelegatingServerLogoutHandler logoutHandler = new DelegatingServerLogoutHandler(
        //         new WebSessionServerLogoutHandler(), new SecurityContextServerLogoutHandler());
        
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.GET ,"/**").permitAll())
                .sessionManagement(session -> session
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
        //.logout((logout) -> logout
        //  .logoutUrl("/user/logout")
        //  .invalidateHttpSession(true));
        // .requestMatchers(HttpMethod.POST, "/user/register").permitAll()
        
    }
}
