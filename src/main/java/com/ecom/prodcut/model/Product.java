package com.ecom.prodcut.model;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	private String description;
	private String category;
	private String subCategory;
	private int price;
	private int quantity;

}
