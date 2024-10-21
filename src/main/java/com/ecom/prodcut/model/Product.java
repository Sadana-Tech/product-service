package com.ecom.prodcut.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String description;
	private String category;
	private String subCategory;
	private int price;
	private int quantity;

}
