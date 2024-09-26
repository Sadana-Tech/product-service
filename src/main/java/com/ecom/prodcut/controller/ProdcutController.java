package com.ecom.prodcut.controller;

import java.util.List;

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
		return new ResponseEntity<Response>(Response.builder().product(productService.create(product)).statusCode(HttpStatus.CREATED.value())
				.statusMsg("Successfully created product.").build(), HttpStatus.CREATED);

	}

	@PutMapping
	public ResponseEntity<Response> update(@RequestBody Product product,@RequestParam int id) {
		log.info("Started executing updating...");
		return new ResponseEntity<Response>(Response.builder().product(productService.update(product,id)).statusCode(HttpStatus.ACCEPTED.value())
				.statusMsg("Successfully updated product.").build(), HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<Response> getAll() {
		return 	new ResponseEntity<Response>(Response.builder().products(productService.getAll()).statusCode(HttpStatus.ACCEPTED.value())
				.statusMsg("Successfully featch all products.").build(),HttpStatus.ACCEPTED);

	}

	@GetMapping("{id}")
	public ResponseEntity<Response> getById(@PathVariable Integer id) {
		return new ResponseEntity<Response>(Response.builder().product(productService.getById(id)).statusCode(HttpStatus.ACCEPTED.value())
				.statusMsg("Successfully featch product by id.").build(), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Response> delete(@PathVariable Integer id) {
		productService.delete(id);
		return new ResponseEntity<Response>(Response.builder().statusCode(HttpStatus.ACCEPTED.value()).statusMsg("Sucessfully product id:"+id+" Deleted.").build(), HttpStatus.ACCEPTED);
	}
}
