package com.ecom.prodcut.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(Include.NON_NULL)
public class Response {

	private int statusCode;
	private String statusMsg;
	private Product product;
	private List<Product> products;

}
