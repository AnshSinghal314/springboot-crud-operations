package com.jspider.spring_boot_simple_crud_operations.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.jspider.spring_boot_simple_crud_operations.dto.ProductRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.ProductResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper{

	Product toproduct(ProductRequestDTO productRequestDTO);
	
	ProductResponceDTO toProductResponceDTO(Product product);
	
	List<Product> toProducts(List<ProductRequestDTO> dtos);
	
	List<ProductResponceDTO> toProductResponceDTOs(List<Product> products);
}
