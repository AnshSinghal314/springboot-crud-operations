package com.jspider.spring_boot_simple_crud_operations.dto; 

public record ProductResponceDTO (

	Integer id,
	String name,
	double price,
	String description,
	String category
	){}
