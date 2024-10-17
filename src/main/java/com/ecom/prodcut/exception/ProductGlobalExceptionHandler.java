package com.ecom.prodcut.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ecom.prodcut.model.Response;

@ControllerAdvice
public class ProductGlobalExceptionHandler {

	@ExceptionHandler(ProductException.class)
	public final ResponseEntity<Response> handleProductException(ProductException e) {
		return new ResponseEntity<Response>(
				Response.builder().errorCode(e.getErrorCode()).errorMsg(e.getErrorDec()).build(), HttpStatus.ACCEPTED);

	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Response> handleProductException(Exception e) {
		return new ResponseEntity<Response>(Response.builder().errorCode(500).errorMsg(e.getMessage()).build(),
				HttpStatus.ACCEPTED);

	}

}
