package com.jspider.spring_boot_simple_crud_operations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspider.spring_boot_simple_crud_operations.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByPrice(Double price);
}
