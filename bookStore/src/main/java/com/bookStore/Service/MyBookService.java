package com.bookStore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.Entity.MyBookList;
import com.bookStore.Repository.MyBookRepo;

@Service
public class MyBookService {
	
	@Autowired
	private MyBookRepo myBook;
	
	public void saveMyBooks(MyBookList book) {
		
		myBook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return myBook.findAll();
	}
	
	public void deleteById(long id) {
		myBook.deleteById((int)id);
	}
}
