package com.codingdojo.books;

import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.codingdojo.books.models.Author;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

@SpringBootTest
class BooksApplicationTests {
	
	
	
	private static Validator validator;
    
	@BeforeAll
	static void setUp() {
	    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	    validator = factory.getValidator();
	}
	
	
	@Test
	void DescriptionNull() {
	    Author author = new Author();
	    author.setName("Charles");
	    author.setLastname("Bukowski");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	@Test
	void nameNull() {
	    Author author = new Author();
	    author.setLastname("Bukowski");
	    author.setDescription("Poeta Estadounidense");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	@Test
	void lastNameNull() {
	    Author author = new Author();
	    author.setDescription("Poeta Estadounidense");
	    author.setName("Charles");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	
	@Test
	void nameMinLength() {
	    Author author = new Author();
	    author.setName("C");
	    author.setDescription("Poeta Estadounidense");
	    author.setLastname("Bukowski");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	@Test
	void descriptionMinLength() {
	    Author author = new Author();
	    author.setName("Charles");
	    author.setLastname("Bukowski");
	    author.setDescription("P");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	@Test
	void lastNameMinLength() {
	    Author author = new Author();
	    author.setDescription("Poeta Estadounidense");
	    author.setLastname("B");
	    author.setName("Charles");
	    Set<ConstraintViolation<Author>> violations = validator.validate(author);
	    for (ConstraintViolation<Author> violation : violations) {
	        System.out.println(violation.getMessage()); 
	    }
	    assertFalse(violations.isEmpty());
	}
	
}
