package com.ecom.prodcut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.prodcut.entity.Product;

@Repository
public interface ProductRepositiry extends JpaRepository<Product, Integer> {

}
