package com.codingdojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findAll();

	Product findPById(Long id);
	
	List<Category> findByProductsNotContains(Product product);

}
