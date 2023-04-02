package com.webmaster.service;

import java.util.Collection;

import com.webmaster.model.Product;

public interface ProductService {
	public abstract void createProduct(Product product);
	public abstract void updateProduct(String productId, Product product);
	public abstract void deleteProduct(String id);
	public abstract Product getProduct(String id);
	public abstract Collection<Product> getAllProducts();
}