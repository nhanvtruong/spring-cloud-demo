package com.example.servicea;

import com.netflix.discovery.EurekaClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServiceaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(EurekaClient eurekaClient) {
		return args -> eurekaClient.getApplications().getRegisteredApplications();
	}

}
