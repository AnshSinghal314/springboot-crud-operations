package com.jspider.spring_boot_simple_crud_operations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.spring_boot_simple_crud_operations.dto.ProductResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
//@RequiredArgsConstructor
@RequestMapping(value = "/User")
public class UserController {
	
//	private final ProductService productService;
	
//	@GetMapping(value="/getProductById/{id}")
//	public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
//		ProductResponceDTO productResponceDTO = productService.getProductById(id);
//		
//		return ResponseEntity.status(HttpStatus.FOUND).body(productResponceDTO);
//	}

	
}
