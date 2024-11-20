package com.example.studentmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jwt")
public class JwtRetriever {

    @GetMapping
    public String jwt(String token) {
        return "Your jwt: Bearer " + token;
    }
}
