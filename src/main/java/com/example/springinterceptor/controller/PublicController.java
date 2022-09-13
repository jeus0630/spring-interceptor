package com.example.springinterceptor.controller;

import com.example.springinterceptor.annotation.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping
    public String hello(){
        return "public hello";
    }
}
