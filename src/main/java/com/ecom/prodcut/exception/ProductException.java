package com.ecom.prodcut.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int errorCode;
	private String errorDec;

}
