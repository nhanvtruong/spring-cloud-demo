package com.example.serviceb.controller;

import com.example.serviceb.client.ServiceAClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceBController {

    private final ServiceAClient serviceClient;

    private static Logger log = LoggerFactory.getLogger(ServiceBController.class);

    public ServiceBController(ServiceAClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @GetMapping("/service-b/greetings")
    @CircuitBreaker(name = "serviceBCircuitBreaker" , fallbackMethod = "fallbackServiceB")
    public String greet() {
        return serviceClient.greetings();
    }

    public String fallbackServiceB(Throwable throwable) {
        log.error(throwable.getMessage(), throwable);
        return "Service A is not ready yet .Wait here , we're in service B...!";
    }
}
