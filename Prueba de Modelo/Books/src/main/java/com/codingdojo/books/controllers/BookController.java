package com.codingdojo.books.controllers;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BookController {
	 private final BookService bookService;
	    
	    public BookController(BookService bookService) {
	        this.bookService = bookService;
	    }
	    
	    @GetMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "/books/index.jsp";
	    }
	    
	    @GetMapping("/books/new")
	    public String newBook(@ModelAttribute("book") Book book) {
	        return "/books/new.jsp";
	    }
	    @PostMapping(value="/books")
	    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "books/new.jsp";
	        } else {
	            bookService.createBook(book);
	            return "redirect:/books";
	        }
	    }
	    
	    @GetMapping("/books/{id}")
	    public String show(@PathVariable("id")Long id, Model model) {
	    	Book showbook = bookService.findBook(id);
	    	model.addAttribute("showbook", showbook);
	    	
	    	return "books/show.jsp";
	    }
	    
	    @PostMapping("/books/{id}")
	    public String destroy(@PathVariable("id") Long id){
	    	bookService.deleteBook(id);
	    	
	    	return "redirect:/books";
	    	
	    }
	    @GetMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id")Long id, Model model) {
	    	Book editBook = bookService.findBook(id);
	    	model.addAttribute("editBook",editBook);
	    	
	    	return "/books/edit.jsp";
	    }
	    
	    @PostMapping("/books/{id}/edit")
	    public String update(@PathVariable("id") Long id,@RequestParam(value="title") String title,
	    		@RequestParam(value="description") String desc,
	    		@RequestParam(value="languaje") String lang,
	    		@RequestParam(value="pages") Integer pages, Model model) {
	    	
	    	Book updatedBook = bookService.updateBook(id, title, desc, lang, pages);
	    	model.addAttribute("showbook", updatedBook);
	    	
	    	return "redirect:/books";
	    	
	    }
}
