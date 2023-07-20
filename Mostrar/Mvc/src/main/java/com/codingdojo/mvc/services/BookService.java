package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Book;
import com.codingdojo.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	//Devolviendo todos los libros.
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    //Creando un libro.
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    //Obteniendo la información de un libro
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    //Actualizando los atributos del libro metiante su ID
    public Book updateBook(Long id, String title, String description, String language, Integer pages) {
    	//Busca un libro mediante su ID
    	Optional<Book> updateBook = bookRepository.findById(id);
    	//Condicion si el libro fue encontrado por su id en la base de datos
    	if(updateBook.isPresent()) {
    		//Obtiene la informacion del libro
    		Book updatedBook = updateBook.get();
    		//Cambiando los campos usando los setters
    		updatedBook.setTitle(title);
    		updatedBook.setDescription(description);
    		updatedBook.setLanguage(language);
    		updatedBook.setNumberOfPages(pages);
    		//Se guarda el libro en el repositorio usando el metodo save
    		 return bookRepository.save(updatedBook);
    	}
    	//Si no lo encuentra retorna nulo
    	else {
    		return null;
    	}
    	
    //Metodo para borrar un libro por su id
    }
    public void deleteBook(Long id) {
    	//Condicion si el libro existe por su ID
    	if(bookRepository.existsById(id)) {
    		//Se borra el libro en la base de datos por us ID usando el metodo deleteByID
    		bookRepository.deleteById(id);
    	}
    	//De lo contrario retorna nulo
    	else {
    		return;
    	}
    }
}
