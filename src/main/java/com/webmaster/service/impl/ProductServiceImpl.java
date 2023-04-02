package com.webmaster.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.webmaster.exceptions.ProductException;
import com.webmaster.model.Product;
import com.webmaster.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
private static Map<String,Product> productRepo = new HashMap<>();
	
	static {
		Product soap = new Product();
		soap.setProductName("LifeBuoy Orange");
		soap.setProductId("SOAP007");
		soap.setPrice(40);
		soap.setDiscount(2);
		soap.setProductBrand("HUL");
		
		productRepo.put(soap.getProductId(), soap);
		
		
		Product shampoo = new Product();
		shampoo.setProductName("Clinic Plus");
		shampoo.setProductId("SHAMPOO001");
		shampoo.setPrice(40);
		shampoo.setDiscount(2);
		shampoo.setProductBrand("HUL");
		
		productRepo.put(shampoo.getProductId(), shampoo);
		
	}
	

	@Override
	public void createProduct(Product product) {
		if(product.getProductId()!=null && !productRepo.containsKey(product.getProductId())) {
			productRepo.put(product.getProductId(), product);
		}else {
			throw new ProductException();
		}
		
	}

	@Override
	public void updateProduct(String productId, Product product) {
		if(productRepo.containsKey(productId)) {
			productRepo.remove(productId);
			productRepo.put(productId, product);
		}else {
			throw new ProductException();
		}
	}

	@Override
	public void deleteProduct(String productId) {
		if(productRepo.containsKey(productId)) {
			productRepo.remove(productId);
		}else {
			throw new ProductException();
		}
		
	}

	@Override
	public Product getProduct(String id) {
		if(productRepo.containsKey(id)) {
			return productRepo.get(id);
		}else  {
			throw new ProductException();
		}
	}

	@Override
	public Collection<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepo.values();
	}
	
}