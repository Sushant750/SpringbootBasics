package com.sonu.springdatajpa;

import com.sonu.springdatajpa.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SpringdatajpaApplicationTests {


	@Value("${productrestapi.services.url}")
	private String baseURl;


	@Test
	void testgetProduct() {
		//System.out.println(baseURl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURl + "1", Product.class);
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
//		Product newProduct = restTemplate.postForObject(baseURl, product, Product.class);
//
//		//"http://localhost:8080/products/details/",product, Product.class
//		Assertions.assertNotNull(newProduct);
//		//Assertions.assertEquals("Galaxy", product.getName());
//	}

	@Test
	public void testUpdateProduct(){
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURl+"1",Product.class);
		product.setPrice(500);
		restTemplate.put(baseURl, product);
	}

}
