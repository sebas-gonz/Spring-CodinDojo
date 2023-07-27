package com.codingdojo.productosycategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	
	@Autowired
	private CategoryProductRepository categoryProductRepository;

	public CategoryProduct createCategoryProduct(CategoryProduct categoryProduct) {

		return categoryProductRepository.save(categoryProduct);
	}

	public List<CategoryProduct> allProducts() {
		return categoryProductRepository.findAll();
	}

	public CategoryProduct findCategoryById(Long id) {

		Optional<CategoryProduct> categoryProduct = categoryProductRepository.findById(id);
		if (categoryProduct.isEmpty()) {
			return null;
		} else {

			return categoryProduct.get();
		}

	}

}
