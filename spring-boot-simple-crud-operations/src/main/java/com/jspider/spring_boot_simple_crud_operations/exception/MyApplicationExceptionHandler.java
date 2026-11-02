package com.jspider.spring_boot_simple_crud_operations.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyApplicationExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(NullPointerException e) {
		e.printStackTrace();

		return e.getMessage();
	}

	@ExceptionHandler(value = ProductNotFoundException.class)
	public String handleProductNotFoundException(ProductNotFoundException e) {
		e.printStackTrace();

		return e.getMessage();
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String , String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<ObjectError> objectErrors = e.getAllErrors();
		Map<String, String> string = new HashMap<>();
		
		for (ObjectError error : objectErrors) {
					
			FieldError fieldError = (FieldError) error;
		
		    String attributeName = fieldError.getField();
		    String message = fieldError.getDefaultMessage();
		
		    string.put(attributeName, message);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(string);
	}
}
