package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Entity.Book;
import com.bookStore.Repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bRepo;
	
	public void save(Book b) {
		bRepo.save(b);
	}
	
	public List<Book> getAllBook(){
		return bRepo.findAll();
		
	}
	
	public Book getBookById(long id) {
		return bRepo.findById((int)id).get();
	}
	
	public void deleteById(long id) {
		bRepo.deleteById((int)id);
	}

}
