package com.jspider.spring_boot_simple_crud_operations.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	private Integer id;
	private String name;
	private double price;
	private String description;
	private String category;
	private LocalDate manufactureDate;
}
