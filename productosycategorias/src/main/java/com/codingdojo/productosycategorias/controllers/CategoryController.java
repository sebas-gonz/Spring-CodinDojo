package com.codingdojo.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.services.CategoryProductService;
import com.codingdojo.productosycategorias.services.CategoryService;
import com.codingdojo.productosycategorias.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryProductService categoryProductService;

	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {

		return "views/new_category.jsp";
	}

	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "views/new_category.jsp";
		}
		categoryService.createCategory(category);

		return "redirect:/categories/new";
	}

	@GetMapping("/categories/{id}")
	public String category(@PathVariable("id") Long id, Model model,
			@ModelAttribute("product_category") CategoryProduct categoryProduct) {
		model.addAttribute("categories", categoryService.findCategoryById(id));
		model.addAttribute("products", productService.findCategoryNotContains(categoryService.findCategoryById(id)));

		return "views/category_product.jsp";
	}

	@PostMapping("/categories/{categoryId}/add")
	public String addProduct(@PathVariable("categoryId") Long categoryId, @RequestParam(name = "product", required = false)Long id,
			@ModelAttribute("product_category") CategoryProduct categoryProduct) {
		if (id == null) {
	        return "redirect:/categories/" + categoryId;
	    }

			Category category = categoryService.findCategoryById(categoryId);
			Product product = productService.findProductById(id);

			categoryProduct.setCategory(category);
			categoryProduct.setProduct(product);

			categoryProductService.createCategoryProduct(categoryProduct);

			return "redirect:/categories/" + category.getId();
		}
}
