package com.nico.demo.springboot;

public class Product {

	
	private String name;
	private Integer id;
	
	public Product(){
		
	}
	
	public Product(String name , Integer id){
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
