package com.sonu.springdatajpa.controller;

import com.sonu.springdatajpa.entities.Product;
import com.sonu.springdatajpa.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;


    private static final Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/products/")
    public List<Product> getListOfProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        LOG.info("Finding Product on basis of id {}", id);
        return productRepository.findById(id).get();
    }

    @PostMapping("/products/details/")
    public Product createProduct(@RequestBody Product product){
        LOG.info("Adding product details with id{}", product.getId());
        return productRepository.save(product);
    }

    @PutMapping("/products/")
    public Product updateProduct(@RequestBody Product product){
        LOG.info("Updating product details with id{}", product.getId());
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") int id){
        LOG.info("Product got deleted with id{}", id);
        productRepository.deleteById(id);
    }
}
