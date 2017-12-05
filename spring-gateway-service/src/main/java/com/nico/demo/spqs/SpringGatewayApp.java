package com.nico.demo.spqs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy
public class SpringGatewayApp {
	public static void main(String args[]) {
		SpringApplication.run(SpringGatewayApp.class, args);
	}
	
}
