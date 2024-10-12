package com.example.serviceb;

import com.netflix.discovery.EurekaClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class ServicebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicebApplication.class, args);
	}

	// Pre-register to minimize the delay, when starting it will take time for eureka service find its registered instances
	@Bean
	public CommandLineRunner run(EurekaClient eurekaClient) {
		return args -> eurekaClient.getApplications().getRegisteredApplications();
	}

}
