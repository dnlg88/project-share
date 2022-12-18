package com.dnlg.projectsharingapi.security.filter;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dnlg.projectsharingapi.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        try{
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class)
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return super.attemptAuthentication(request, response);
    }
}
