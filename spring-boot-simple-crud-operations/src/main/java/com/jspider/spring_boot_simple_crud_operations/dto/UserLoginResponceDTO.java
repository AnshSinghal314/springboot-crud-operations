package com.jspider.spring_boot_simple_crud_operations.dto;

import java.util.List;

public record UserLoginResponceDTO(
		String message ,
		String email ,
		List<String> roles
		) {}
