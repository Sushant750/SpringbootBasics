package com.sonu.springdatajpa;

import com.sonu.springdatajpa.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringdatajpaApplicationTests {


	@Test
	void testgetProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/products/3", Product.class);
		Assertions.assertNotNull(product);
		Assertions.assertEquals("Samsung", product.getName());

	}
//	@Test
//	public void testCreateProduct(){
//		RestTemplate restTemplate = new RestTemplate();
//		Product product = new Product();
//		product.setName("Galaxy");
//		product.setDescription("Awesome Product by Samsung");
//		product.setPrice(500000);
//
//		Product newProduct = restTemplate.postForObject("http://localhost:8080/products/details/", product, Product.class);
//
//		//"http://localhost:8080/products/details/",product, Product.class
//		Assertions.assertNotNull(newProduct);
//		//Assertions.assertEquals("Galaxy", product.getName());
//	}

	@Test
	public void testUpdateProduct(){
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject("http://localhost:8080/products/1", Product.class);
		product.setPrice(100);
		restTemplate.put("http://localhost:8080/products/", product);

	}

}
