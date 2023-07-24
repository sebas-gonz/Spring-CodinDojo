package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.codingdojo.books.models.Book;


public interface BookRepository extends CrudRepository<Book, Long>{
	
	//Este método recupera todos los libros de la base de datos
    List<Book> findAll();
    //Este método encuentra un libro por su descripción
    List<Book> findByDescriptionContaining(String search);
    //Este método cuenta cuántos libros contiene cierta cadena en el título
    Long countByTitleContaining(String search);
    //Este método borra un libro que empieza con un título específico
    Long deleteByTitleStartingWith(String search);
    //Metodo que borra un libro por su ID
    void deleteById(Long id);

}
