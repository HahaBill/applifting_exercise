package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableJpaRepositories("com.example.demo.repository")
@EntityScan(basePackages = "com.example.demo.models")
@ComponentScan({"com.examle.demo.controllers"})
@SpringBootApplication
public class DemoApplication {

    @Value("${server.port}")
    private int port;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	Testing purposes
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void showLocalHost() {
        System.out.println(String.format("http://localhost:%d", this.port));
    }

}
