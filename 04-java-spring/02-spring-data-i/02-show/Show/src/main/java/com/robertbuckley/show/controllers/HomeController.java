package com.robertbuckley.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.robertbuckley.show.models.Book;
import com.robertbuckley.show.services.BookService;

@RestController
public class HomeController {
	//dependancy injection
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public List<Book> index(){
		return this.bService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return this.bService.getSingleBook(id);
	}
	
	@PostMapping("/")
	public Book create (Book book) {
		return this.bService.createBook(book);
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}
}

// SELECT * FROM books