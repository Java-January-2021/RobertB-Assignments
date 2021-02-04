package com.robertbuckley.show.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.robertbuckley.show.models.Book;
import com.robertbuckley.show.repositories.ShowRepository;

@Service
public class BookService {
	// Dependency Injection
	private ShowRepository bRepo;
	
	public BookService(ShowRepository repo) {
		this.bRepo = repo;
	}
	
	// Get All Books
	public List<Book> getAllBooks(){
		return this.bRepo.findAll();
	}
	// get one book
	public Book getSingleBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	// create a book
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	// delete a book
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}

	public Book updateBook(Long id, Book bookToUpdate) {
		// TODO Auto-generated method stub
		return this.bRepo.save(bookToUpdate);
		
	}


}
