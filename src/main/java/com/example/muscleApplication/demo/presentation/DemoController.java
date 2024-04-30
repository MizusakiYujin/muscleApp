package com.example.muscleapplication.demo.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/test")
    public String get(){
        return "Hello";
    }
}
