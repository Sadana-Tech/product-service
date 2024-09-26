package com.ecom.prodcut.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.prodcut.constants.ErrorConstants;
import com.ecom.prodcut.exception.ProductException;
import com.ecom.prodcut.model.Product;
import com.ecom.prodcut.repository.ProductRepositiry;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepositiry productRepositiry;

	@Override
	public List<Product> getAll() {
		List<Product> products = null;
		try {
			products = productRepositiry.findAll().stream().map(prod -> convert(prod)).collect(Collectors.toList());
			return products;
		} catch (Exception e) {
			throw new ProductException(ErrorConstants.TECHNICAL_SERVER_EXCEPTION.getErrorCode(),
					ErrorConstants.TECHNICAL_SERVER_EXCEPTION.getErrorMsg());

		} finally {
			if (products.isEmpty())
				throw new ProductException(ErrorConstants.PRODUCT_NOT_EXIST.getErrorCode(),
						ErrorConstants.PRODUCT_NOT_EXIST.getErrorMsg());
		}

	}

	@Override
	public Product create(Product product) {
		try {
			return convert(productRepositiry.save(convert(product)));
		} catch (Exception e) {
			throw new ProductException(ErrorConstants.TECHNICAL_SERVER_EXCEPTION.getErrorCode(),
					ErrorConstants.TECHNICAL_SERVER_EXCEPTION.getErrorMsg());
		}
	}

	@Override
	public Product update(Product product , int id) {
		
		try {		
			product.setId(id);
			return convert(productRepositiry.save(convert(product)));
			
		}catch(ProductException e) {
			throw new ProductException(ErrorConstants.PRODUCT_NOT_EXIST.getErrorCode(),
					ErrorConstants.PRODUCT_NOT_EXIST.getErrorMsg());
		}
	}

	@Override
	public void delete(int id) {
		try {
			productRepositiry.deleteById(id);
		}catch(ProductException e) {
			throw new ProductException(ErrorConstants.UNABLE_TO_DELETE.getErrorCode(),
					ErrorConstants.UNABLE_TO_DELETE.getErrorMsg());
		}
	}

	@Override
	public Product getById(int id) {
		try {
			return convert(productRepositiry.findById(id).orElse(null));
		}catch(ProductException e) {
			throw new ProductException(ErrorConstants.PRODUCT_NOT_EXIST.getErrorCode(),
					ErrorConstants.PRODUCT_NOT_EXIST.getErrorMsg());
		}
	}


	@Override
	public List<Product> getByName(String name) {
		try {
			return productRepositiry.findByName(name).stream().map(product -> convert(product))
					.collect(Collectors.toList());
		}catch(ProductException e) {
			throw new ProductException(ErrorConstants.PRODUCT_NOT_EXIST.getErrorCode(),
					ErrorConstants.PRODUCT_NOT_EXIST.getErrorMsg());
		}

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
