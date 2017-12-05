package com.nico.demo.spqs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@SpringBootApplication
@EnableConfigServer
public class SpringConfigServiceApp {
	public static void main(String args[]) {
		SpringApplication.run(SpringConfigServiceApp.class, args);
	}
	
}
