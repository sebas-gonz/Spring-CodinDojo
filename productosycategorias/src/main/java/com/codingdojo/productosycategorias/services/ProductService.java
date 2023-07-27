package com.codingdojo.productosycategorias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product createProduct(Product product) {
		
		return productRepository.save(product);
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public Product findProductById(Long id) {
		
		return productRepository.findProductById(id);
	}
	
	public List<Product> findCategoryNotContains(Category category){
		
		return productRepository.findByCategoriesNotContains(category);
	}

}
