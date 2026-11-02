package com.jspider.spring_boot_simple_crud_operations.response_structure;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@Data
@JsonPropertyOrder({"statusCode" , "message" , "data"})
public class myResponseStructure<T> {

	private int statusCode;
	private String message;
	private T data;
}
