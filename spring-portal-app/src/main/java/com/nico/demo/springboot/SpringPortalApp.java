package com.nico.demo.springboot;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class SpringPortalApp {

	public static void main(String args[]) {
		SpringApplication.run(SpringPortalApp.class, args);
	}

	@Autowired
	private RestTemplate restTemp;

	@RequestMapping("/")
	public Object[] landing() {

		ResponseEntity<Product[]> responseEntity = restTemp.getForEntity("http://product-app/product/",
				Product[].class);

		ArrayList<String> li = new ArrayList<String>();
		for (Product p : responseEntity.getBody()) {
			li.add(p.getName());
		}
		return li.toArray();
	}

	@RequestMapping("/hm")
	public Object[] landing2() {

		ParameterizedTypeReference<Resources<Product>> ptr = new ParameterizedTypeReference<Resources<Product>>() {
		};
		ResponseEntity<Resources<Product>> ex = restTemp.exchange("http://product-app:8080/products/", HttpMethod.GET,
				null, ptr);

		return ex.getBody().getContent().stream().map(Product::getName).collect(Collectors.toList()).toArray();
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
