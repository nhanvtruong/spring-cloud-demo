package com.example.servicea.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceAController {

    @GetMapping("/service-a/greetings")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String greet() {
        return "Hello World From Service A";
    }
}
