package com.jspider.spring_boot_simple_crud_operations.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;


public record ProductRequestDTO (
		
	@Positive(message = "Id should be in positive")
	Integer id,
	String name,
	@Positive(message = "price should be in prositive")
	@Min(value = 300 , message = "price should be greater than 300")
	double price,
	String description,
	String category,
	@Positive(message = "mfd should be a present date or the past data not the future date")
	@PastOrPresent
	LocalDate manufactureDate
	) {}