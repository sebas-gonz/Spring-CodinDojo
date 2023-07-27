package com.codingdojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;

public interface ProductRepository extends CrudRepository<Product,Long>{
	
	List <Product> findAll();
	
	Product findProductById(Long id);
	
	List<Product> findByCategoriesNotContains(Category category);

}
