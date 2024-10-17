package com.ecom.prodcut.constants;

public enum ErrorConstants {

	PRODUCT_NOT_EXIST(501, "Product not available in DB."),
	TECHNICAL_SERVER_EXCEPTION(502, "Server exception, unable to process the request."),
	UNABLE_TO_DELETE(501, "Unable to delete record.");

	private int errorCode;
	private String errorMsg;

	private ErrorConstants(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
