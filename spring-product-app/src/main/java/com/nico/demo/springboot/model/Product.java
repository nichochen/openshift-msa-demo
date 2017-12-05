package com.nico.demo.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Product() {

	}

	private Product(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	 public Integer getId() {
	 return id;
	 }

	 public void setId(Integer id) {
	 this.id = id;
	 }

}
