package com.nico.demo.springboot.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nico.demo.springboot.model.Product;
import com.nico.demo.springboot.model.ProductRepository;
import com.nico.demo.springboot.service.DataService;

import io.swagger.annotations.Api;

@RestController
@Api(value="Product",description="Product APIs")
public class ProductController {

	@Autowired
	private DataService ds;

	@RequestMapping("/greeting")
	public String greeting() {
		return "Hello!";
	}

	@Autowired
	private ProductRepository tp;
	
	@GetMapping("/product")
	public  Collection<Product> getAllProducts() {
		return tp.findAll();
	}

	@RequestMapping("/product/{id}")
	public Product getProduct(@PathVariable int id) {
		return ds.getProduct(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/product/{id}")
	public void deleteProduct(@PathVariable int id) {
		ds.deleteProduct(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/product")
	public void addProduct(@RequestBody Product product) {
		ds.addProduct(product);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/product")
	public void updateProduct(@RequestBody Product product) {
		ds.updateProduct(product);
	}

	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}