package com.jspider.spring_boot_simple_crud_operations.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jspider.spring_boot_simple_crud_operations.dto.ProductRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.ProductResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.Product;
import com.jspider.spring_boot_simple_crud_operations.response_structure.myResponseStructure;
import com.jspider.spring_boot_simple_crud_operations.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/product")
public class ProductController {

	private final ProductService productService;
	
	@PostMapping(value = "/saveProduct")
	public ResponseEntity<ProductResponceDTO> saveProduct(@RequestBody ProductRequestDTO dto) {
		ProductResponceDTO productResponceDTO = productService.saveProduct(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productResponceDTO);
	}
	
	@GetMapping(value="/getProductById/{id}")
	public ResponseEntity<Object> getProductById(@PathVariable Integer id) {
		ProductResponceDTO productResponceDTO = productService.getProductById(id);
	
			return ResponseEntity.status(HttpStatus.FOUND).body(productResponceDTO);
	}
	
	@DeleteMapping(value="/deleteProductById/{id}")
	public ResponseEntity<Integer>deleteProductById(@PathVariable Integer id) {
		
		boolean result = productService.DeleteProductById(id);
		 if(result) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(id);
		 }
		 	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	@PostMapping(value="/registerMultipleProducts")
	public ResponseEntity<List<ProductResponceDTO>> registerMultipleProducts(@RequestBody List<ProductRequestDTO> requestDTO){
	
		if(!requestDTO.isEmpty()) {
			List<ProductResponceDTO> responceDTOs = productService.saveMultipleProducts(requestDTO);
			
				return ResponseEntity.status(HttpStatus.CREATED).body(responceDTOs);
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(null);
	}
	
	@GetMapping(value="/getAllProduct")
	public ResponseEntity<List<ProductResponceDTO>> getProduct() {
		List<ProductResponceDTO> responceDTOs = productService.getAllProducts();
		
		if(responceDTOs != null) {
			return ResponseEntity.status(HttpStatus.OK).body(responceDTOs);
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responceDTOs);
	}
	
	@GetMapping(value="/getProductByPrice/{price}")
	public ResponseEntity<List<ProductResponceDTO>> getProductByPrice(@PathVariable Double price) {
		List<ProductResponceDTO> productResponceDTOs = productService.getProductByPrice(price);
		if(productResponceDTOs != null) {
			return ResponseEntity.status(HttpStatus.OK).body(productResponceDTOs);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(productResponceDTOs);
	}
	
	@GetMapping(value= "/sortProductInASC/{atributeName}")
	public ResponseEntity<myResponseStructure<List<Product>>> sortProductInASC(@PathVariable String atributeName) {
		myResponseStructure<List<Product>> myResponseStructure = productService.sortProductInASC(atributeName);
		
		return ResponseEntity.status(myResponseStructure.getStatusCode()).body(myResponseStructure);
	}
	
	@GetMapping(value= "/sortProductInDESC/{atributeName}")
	public ResponseEntity<myResponseStructure<List<Product>>> sortProductInDESC(@PathVariable String atributeName) {
		myResponseStructure<List<Product>> myResponseStructure = productService.sortProductInDESC(atributeName);
		
		return ResponseEntity.status(myResponseStructure.getStatusCode()).body(myResponseStructure);
	}
	
	@GetMapping(value = "/displayProjectByPageNumber/{pageNumber}")
	public Page<Product> displayProductByPageNumber(@PathVariable int pageNumber) {
		return productService.displayProductByPager(pageNumber);
	}
//	=============================================================================================
	
	
	
	@PostMapping(value="/registerProduct")
	public ProductRequestDTO registerProduct(@RequestBody ProductRequestDTO requestDTO) {
		System.out.println(requestDTO);
		return requestDTO;
	}
	
	
	@GetMapping(value="/getProductByName")
	public String getProductByName(@RequestParam String name) {
		
		return "no product is avaliable";
	}
	
//	=================================================================================================
	
	
}
