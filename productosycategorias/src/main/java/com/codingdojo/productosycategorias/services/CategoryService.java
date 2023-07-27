package com.codingdojo.productosycategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	public Category createCategory(Category category) {

		return categoryRepository.save(category);
	}

	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}

	public Category findCategoryById(Long id) {

		Optional<Category> category = categoryRepository.findById(id);
		if (category.isEmpty()) {
			return null;
		} else {

			return category.get();
		}

	}
	
	public List<Category> findProductNotContain(Product product){
		return categoryRepository.findByProductsNotContains(product);
	}
}
