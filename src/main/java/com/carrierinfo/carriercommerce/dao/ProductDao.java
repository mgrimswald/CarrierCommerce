package com.carrierinfo.carriercommerce.dao;

import java.util.List;

import com.carrierinfo.carriercommerce.model.Product;

public interface ProductDao {
	
	Product addProduct(Product product);
	Product findProductById(Long id);
	List<Product> getAllProducts();
	void updateProduct(Product product);
	void removeProduct(Product product);

}
