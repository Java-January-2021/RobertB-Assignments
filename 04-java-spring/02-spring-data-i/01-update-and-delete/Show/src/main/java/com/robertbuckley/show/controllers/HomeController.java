package com.robertbuckley.show.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.robertbuckley.show.models.Book;
import com.robertbuckley.show.services.BookService;

@Controller
public class HomeController {
	//dependancy injection
	@Autowired
	private BookService bService;
	
	
//	@GetMapping("/")
//	public List<Book> index(){
//		return this.bService.getAllBooks();
//	}
//	
//	@GetMapping("/books/{id}")
//	public Book getBook(@PathVariable("id") Long id) {
//		return this.bService.getSingleBook(id);
//	}
	
//	@PostMapping("/create")
//	public Book create (Book book) {
//		return this.bService.createBook(book);
//	}
	@RequestMapping("/books/newBook")
	public String newBook(@ModelAttribute("book") Book book) {
		return "newBook.jsp";
	}
	@RequestMapping(value="/createBook", method=RequestMethod.POST)
		public String createBook(@Validated @ModelAttribute("book") Book book, BindingResult result) {
			if(result.hasErrors()) {
				return "newBook.jsp";
			}
			this.bService.createBook(book);
			return "redirect:/books";
		}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") Long id) {
		this.bService.deleteBook(id);
	}
	@RequestMapping("/books/{id}")
	public String book(Model viewModel, @PathVariable("id") Long id) {
		Book book = bService.getSingleBook(id);
		viewModel.addAttribute("book", book);
		return "showBook.jsp";
	}
	@RequestMapping("/books")
	public String index(Model viewModel){
		List<Book> books = bService.getAllBooks();
		viewModel.addAttribute("books", books);
		return "books.jsp";
	}
	@RequestMapping("/books/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model viewModel) {
		Book book = bService.getSingleBook(id);
		if(book != null) {
			viewModel.addAttribute("book", book);
			return "editBook.jsp";
		}
		else {
			return "redirect:/books";
		}
	}
	@PostMapping("/books/edit/{id}")
	public String updateBook(@PathVariable("id") Long id, @Validated @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		else {
			this.bService.updateBook(id, book);
			return "redirect:/books";
		}
	}
	@RequestMapping("/books/delete/{id}")
	public String eraseBook(@PathVariable("id") Long id, @Validated @ModelAttribute("book") Book book, BindingResult result) {
		bService.deleteBook(id);
		return "redirect:/books";
	}
}

// SELECT * FROM books