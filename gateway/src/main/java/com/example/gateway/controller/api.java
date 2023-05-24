package com.example.gateway.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class api {

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
