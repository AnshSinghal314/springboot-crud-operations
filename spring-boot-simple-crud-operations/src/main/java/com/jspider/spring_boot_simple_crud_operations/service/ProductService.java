package com.jspider.spring_boot_simple_crud_operations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jspider.spring_boot_simple_crud_operations.dto.ProductRequestDTO;
import com.jspider.spring_boot_simple_crud_operations.dto.ProductResponceDTO;
import com.jspider.spring_boot_simple_crud_operations.entity.Product;
import com.jspider.spring_boot_simple_crud_operations.exception.ProductNotFoundException;
import com.jspider.spring_boot_simple_crud_operations.mapper.ProductMapper;
import com.jspider.spring_boot_simple_crud_operations.repository.ProductRepository;
import com.jspider.spring_boot_simple_crud_operations.response_structure.myResponseStructure;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ProductService {

	private final ProductRepository productRepository;
	private final ProductMapper productMapper;

	@Transactional
	public ProductResponceDTO saveProduct(ProductRequestDTO requestDTO) {

		Product product = productMapper.toproduct(requestDTO);

		Product dbProduct = productRepository.save(product);

		return productMapper.toProductResponceDTO(dbProduct);

	}

	public ProductResponceDTO getProductById(int id) {
		Optional<Product> product = productRepository.findById(id);

		if (product.isEmpty()) {
			throw new ProductNotFoundException("No Product Found");
		}

		return productMapper.toProductResponceDTO(product.get());
	}

	@Transactional
	public boolean DeleteProductById(int id) {

		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Transactional
	public List<ProductResponceDTO> saveMultipleProducts(List<ProductRequestDTO> productRequestDTOs) {

		if (!productRequestDTOs.isEmpty()) {
			List<Product> productList = productMapper.toProducts(productRequestDTOs);

			productRepository.saveAll(productList);

			return productMapper.toProductResponceDTOs(productList);
		}

		return null;
	}

	public List<ProductResponceDTO> getAllProducts() {
		List<Product> products = productRepository.findAll();
		if (!products.isEmpty()) {
			return productMapper.toProductResponceDTOs(products);
		}

		return null;
	}

	public List<ProductResponceDTO> getProductByPrice(Double price) {
		List<Product> products = productRepository.findByPrice(price);

		if (products.isEmpty()) {
			return null;
		}
		return productMapper.toProductResponceDTOs(products);

	}

	public myResponseStructure<List<Product>> sortProductInASC(String attributeName) {
		List<Product> products = productRepository.findAll(Sort.by(Direction.ASC, attributeName));
		myResponseStructure<List<Product>> myResponseStructure = new myResponseStructure<>();

		if (products.isEmpty()) {
			myResponseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			myResponseStructure.setMessage("There are no products avaliable");
			myResponseStructure.setData(products);
			return myResponseStructure;
		}
		myResponseStructure.setStatusCode(HttpStatus.FOUND.value());
		myResponseStructure.setMessage("Products are ........");
		myResponseStructure.setData(products);
		return myResponseStructure;
	}

	public myResponseStructure<List<Product>> sortProductInDESC(String attributeName) {
		List<Product> products = productRepository.findAll(Sort.by(Direction.DESC, attributeName));
		myResponseStructure<List<Product>> myResponseStructure = new myResponseStructure<>();

		if (products.isEmpty()) {
			myResponseStructure.setStatusCode(HttpStatus.NO_CONTENT.value());
			myResponseStructure.setMessage("There are no products avaliable");
			myResponseStructure.setData(products);
			return myResponseStructure;
		}
		myResponseStructure.setStatusCode(HttpStatus.FOUND.value());
		myResponseStructure.setMessage("Products are ........");
		myResponseStructure.setData(products);
		return myResponseStructure;
	}  
	
	public Page<Product> displayProductByPager(int pageNumber){
		return productRepository.findAll(PageRequest.of(pageNumber, 4));
	}
}
