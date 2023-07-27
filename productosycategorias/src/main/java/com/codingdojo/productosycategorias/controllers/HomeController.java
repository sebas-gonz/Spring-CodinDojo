package com.codingdojo.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.productosycategorias.services.CategoryService;
import com.codingdojo.productosycategorias.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;


	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("products", productService.allProducts());
		model.addAttribute("categories", categoryService.allCategories());

		return "views/home.jsp";
	}

	@PostMapping("/products")
	public String product(@RequestParam("products") Long productId) {
		return "redirect:/products/"+productId;
		
	}
	
	@PostMapping("/categories")
	public String category(@RequestParam("categories") Long categoryId) {
		return "redirect:/categories/"+categoryId;
		
	}

}
