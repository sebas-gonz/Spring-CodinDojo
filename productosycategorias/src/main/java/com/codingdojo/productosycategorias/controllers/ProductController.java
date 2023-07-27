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
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryProductService categoryProductService;
	
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		
		return "views/new_product.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product")Product product,BindingResult result) {
		if(result.hasErrors()) {
			return "views/new_product.jsp";
		}
		productService.createProduct(product);
		
		return "redirect:/products/new";
	}
	
	@GetMapping("/products/{id}")
	public String product(@PathVariable("id")Long id, Model model,@ModelAttribute("product_category")CategoryProduct categoryProduct) {
		model.addAttribute("product", productService.findProductById(id));
		model.addAttribute("categories", categoryService.findProductNotContain(productService.findProductById(id)));
		
		return "views/product_category.jsp";
		
	}
	
	@PostMapping("/products/{productId}/add")
	
	public String addCategory(@PathVariable("productId")Long productId,@RequestParam(name = "category", required = false)Long id,
			@ModelAttribute("product_category")CategoryProduct categoryProduct) {
		 if (id == null) {
		        return "redirect:/products/" + productId;
		    }

		Product product = productService.findProductById(productId);
		Category category = categoryService.findCategoryById(id);
		
		categoryProduct.setProduct(product);
		categoryProduct.setCategory(category);
		
		categoryProductService.createCategoryProduct(categoryProduct);
		
		return "redirect:/products/" + product.getId();
		
		
	}
	
	
	
	
}
