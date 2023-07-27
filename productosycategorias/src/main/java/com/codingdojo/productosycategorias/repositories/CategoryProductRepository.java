package com.codingdojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.models.Product;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {

	List<CategoryProduct> findAll();

	Product findCategoryProductById(Long id);

}
