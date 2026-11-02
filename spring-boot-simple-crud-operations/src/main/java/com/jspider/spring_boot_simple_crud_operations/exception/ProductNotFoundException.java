package com.jspider.spring_boot_simple_crud_operations.exception;

public class ProductNotFoundException  extends RuntimeException{

	
	public ProductNotFoundException (String msg) {
		super(msg);
	}
}
