package com.webmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webmaster.model.Product;
import com.webmaster.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value="/products/{id}")
	public ResponseEntity<Object> getProduct(@PathVariable("id") String id) {
			return new ResponseEntity<Object>(productService.getProduct(id), HttpStatus.OK);	
	}
	
	@GetMapping(value="/products")
	public ResponseEntity<Object> getAllProducts() {
			return new ResponseEntity<Object>(productService.getAllProducts(), HttpStatus.OK);
		
	}
	
	@PostMapping(value="/products")
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
			productService.createProduct(product);
			return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
		
	}
	
	@PutMapping(value="/products/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
			productService.updateProduct(id, product);
			return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
		
	}
	
	@DeleteMapping(value="/products/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable("id") String id) {
			productService.deleteProduct(id);
			return new ResponseEntity<>("Product is deleted successfully", HttpStatus.OK);
	}
	
}