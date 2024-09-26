package com.ecom.prodcut.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.prodcut.exception.ProductException;
import com.ecom.prodcut.model.Product;
import com.ecom.prodcut.model.Response;
import com.ecom.prodcut.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProdcutController {

	private ProductService productService;

	@Autowired
	public ProdcutController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping()
	public ResponseEntity<Response> create(@RequestBody Product product) {
		log.info("Started executing Create...");
		return new ResponseEntity<Response>(Response.builder().product(productService.create(product)).statusCode(200)
				.statusMsg("Successfully created product.").build(), HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Product> update(@RequestBody Product product) {
		log.info("Started executing updating...");
		return new ResponseEntity<Product>(productService.create(product), HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Response> getAll() {
		return 	new ResponseEntity<Response>(Response.builder().products(productService.getAll()).build(),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id) {
		return new ResponseEntity<Product>(productService.getById(id), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id) {
		productService.delete(id);
		return new ResponseEntity<Integer>(id, HttpStatus.ACCEPTED);
	}

	@GetMapping("/")
	public ResponseEntity<Response> getById(@RequestParam String name) {
		try {
			return new ResponseEntity<Response>(Response.builder().products(productService.getByName(name)).build(),
					HttpStatus.ACCEPTED);
		} catch (ProductException e) {
			return new ResponseEntity<Response>(
					Response.builder().errorCode(e.getErrorCode()).errorMsg(e.getErrorDec()).build(),
					HttpStatus.ACCEPTED);

		}

	}
}
