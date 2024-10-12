package com.example.serviceb.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "service-a")
public interface ServiceAClient {

    @GetMapping("/service-a/greetings")
    String greetings();
}
