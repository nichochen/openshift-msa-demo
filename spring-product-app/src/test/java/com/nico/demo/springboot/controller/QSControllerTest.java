package com.nico.demo.springboot.controller;

import org.junit.Test;
import org.junit.Assert;

public class QSControllerTest {

	@Test
	public void testGreeting(){
		ProductController c = new ProductController();
		Assert.assertNotNull(c.greeting());
	}
}
