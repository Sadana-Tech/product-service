package com.ecom.prodcut.service;

import java.util.List;

import com.ecom.prodcut.model.Product;


public interface ProductService {

	public List<Product> getAll();

	public Product create(Product product);

	public Product update(Product product);

	public void delete(int id);
	
	public Product getById(int id);

}
