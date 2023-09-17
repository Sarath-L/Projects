package com.bookStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bookStore.Entity.Book;
import com.bookStore.Entity.MyBookList;
import com.bookStore.Service.BookService;
import com.bookStore.Service.MyBookService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookService bookService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list=service.getAllBook();
		return new ModelAndView("bookList","book",list);
	}
	
	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		
		List<MyBookList> list= bookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute("Book") Book b) {
		service.save(b);
		return "redirect:/available_books";
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id" )long id) {
		Book b=service.getBookById(id);
		MyBookList list= new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		bookService.saveMyBooks(list);
		return "redirect:/my_books";
	}
	
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") long id,Model model) {
		
		Book b=service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}
	
	@RequestMapping("/deleteBook/{id}")
	
	public String deleteBook(@PathVariable("id") long id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}

}
