package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
@Autowired
private BookRepository bookRepository;

	List<Book> getAllBooks()
	{
		return bookRepository.findAll();
	}
	
	Optional<Book> getBook(int id)
	{
		return bookRepository.findById(id);
	}
	
	Book addBook(Book book)
	{
		return bookRepository.save(book);
	}
	
	void deleteBook(int id)
	{
		bookRepository.deleteById(id);
	}
	
	boolean getBookTitleStatus(String book)
	{
		Book t = bookRepository.findByTitle(book);
		
		if (t==null)
			return false;
		
		return true;
	}
	
	boolean getBookISBNStatus(String book)
	{
		Book t = bookRepository.findByISBN(book);
		
		if (t==null)
			return false;
		
		return true;
	}
}