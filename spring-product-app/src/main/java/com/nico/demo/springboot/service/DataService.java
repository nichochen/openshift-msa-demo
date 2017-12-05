package com.nico.demo.springboot.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nico.demo.springboot.model.Product;
import com.nico.demo.springboot.model.ProductRepository;

@Service
public class DataService {

	@Autowired
	private ProductRepository tp;

	public Collection<Product> getProduct() {
		return tp.findAll();
	}

	public Product getProduct(int id) {
		return tp.findOne(id);
	}

	public void deleteProduct(int id) {
		tp.delete(id);
	}

	public void addProduct(Product product) {
		tp.save(product);
	}

	public void updateProduct(Product product) {
		tp.save(product);
	}
}
