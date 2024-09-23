package com.ecom.prodcut.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.prodcut.model.Product;
import com.ecom.prodcut.repository.ProductRepositiry;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositiry productRepositiry;

	@Override
	public List<Product> getAll() {

		return productRepositiry.findAll().stream().map(prod -> convert(prod)).collect(Collectors.toList());
	}

	@Override
	public Product create(Product product) {
		return convert(productRepositiry.save(convert(product)));
	}

	@Override
	public Product update(Product product) {
		return convert(productRepositiry.save(convert(product)));
	}

	@Override
	public void delete(int id) {

		productRepositiry.deleteById(id);
	}

	@Override
	public Product getById(int id) {

		return convert(productRepositiry.findById(id).orElse(null));
	}

	private com.ecom.prodcut.entity.Product convert(Product product) {

		com.ecom.prodcut.entity.Product entityProduct = new com.ecom.prodcut.entity.Product();
		BeanUtils.copyProperties(product, entityProduct);
		return entityProduct;

	}

	private Product convert(com.ecom.prodcut.entity.Product entityProduct) {
		Product product = new Product();
		if (entityProduct != null)
			BeanUtils.copyProperties(entityProduct, product);
		return product;

	}

}
