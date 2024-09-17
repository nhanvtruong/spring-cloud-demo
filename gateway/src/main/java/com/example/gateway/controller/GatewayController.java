package com.example.gateway.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class GatewayController {

    @PostMapping("/fallback")
    public Flux<String> gatewayFallBack(){
        return Flux.just("Hello from gateway , you request cannot be sent");
    }
}
