package com.example.studentmanagement.auth;

import com.example.studentmanagement.util.JwtUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CustomOAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private JwtUtil jwtUtil;

    public CustomOAuth2SuccessHandler() {
        this.jwtUtil = new JwtUtil();
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication
    ) throws IOException, ServletException {
        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
        String email = oauthToken.getPrincipal().getAttribute("email");
        String jwt = jwtUtil.generateToken(email);
//        response.addHeader("Authorization", "Bearer " + jwt);
        response.sendRedirect("/jwt?token=" + jwt);
    }
}

