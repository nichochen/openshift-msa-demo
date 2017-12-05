package com.nico.demo.spqs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class SpringServiceDiscoverApp {
	public static void main(String args[]) {
		SpringApplication.run(SpringServiceDiscoverApp.class, args);
	}
	
}
