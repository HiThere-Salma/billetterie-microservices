package com.example.event_serviceee;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  // ou @EnableEurekaClient
public class EventServiceeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventServiceeeApplication.class, args);
	}
}