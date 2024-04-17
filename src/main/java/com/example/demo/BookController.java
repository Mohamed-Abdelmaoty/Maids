package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private PatronService patronService;
	@Autowired
	private BorrowSevice borrowService;

	@GetMapping("/books")
	List<Book> getBooks()
	{
		return bookService.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	Optional<Book> getBook(@PathVariable int id) throws NotFoundException
	{
		return Optional.ofNullable(bookService.getBook(id).orElseThrow((() -> new IDnotFoundException("Book not exist"))));
	}
	
	@PostMapping("/books")
	void addBooks(@RequestBody Book book) throws Exception
	{
		book.setId(0);
		book.setInsertionDate(LocalDateTime.now());
		
		boolean title = bookService.getBookTitleStatus(book.getTitle());
		boolean ISBN = bookService.getBookISBNStatus(book.getISBN());
		
		if(title)
			throw new Exception("Book is alreay exist");
		
		if(ISBN)
			throw new Exception("ISBN is alreay configured with another book");
		
		bookService.addBook(book);
	}
	
	@PutMapping("/books/{id}")
	void updateBooks(@RequestBody Book book,@PathVariable int id)
	{
		book.setId(id);
		bookService.addBook(book);
	}
	
	@DeleteMapping("/books/{id}")
	void updateBooks(@PathVariable int id)
	{
		bookService.deleteBook(id);
	}
	
	@GetMapping("/patrons")
	List<Patron> getPatrons()
	{
		return patronService.getAllPatrons();
	}
	
	@GetMapping("/patrons/{id}")
	Optional<Patron> getPatron(@PathVariable int id) throws NotFoundException
	{
		return Optional.ofNullable(patronService.getPatron(id).orElseThrow((() -> new IDnotFoundException("Patron not exist"))));
	}
	
	@PostMapping("/patrons")
	void addpatrons(@RequestBody Patron patron)
	{
		patron.setId(0);
		patron.setJoinDate(LocalDateTime.now());
		patronService.addPatron(patron);
	}
	
	@PutMapping("/patrons/{id}")
	void updatePatrons(@RequestBody Patron patron,@PathVariable int id)
	{
		patron.setId(id);
		patronService.addPatron(patron);
	}
	
	@DeleteMapping("/patrons/{id}")
	void deletePatrons(@PathVariable int id)
	{
		patronService.deletePatron(id);
	}
	
	@GetMapping("/borrow")
	List<Borrow> getBorrows()
	{
		return borrowService.getAllBorrows();
	}
	
	@GetMapping("/borrow/{id}")
	Optional<Borrow> getBorrow(@PathVariable int id) throws NotFoundException
	{
		return Optional.ofNullable(borrowService.getBorrow(id).orElseThrow((() -> new IDnotFoundException("Borrow ID not exist"))));
	}
	
	@PostMapping("/borrow/{bookId}/patron/{patronId}")
	Borrow addpatrons(@PathVariable int bookId,@PathVariable int patronId) throws Exception
	{
		Optional<Book> book_status = bookService.getBook(bookId);
		Optional<Patron> patron_status = patronService.getPatron(patronId);
		
		
		if(book_status.isEmpty())
			throw new IDnotFoundException("Book ID not exist");
		else if( patron_status.isEmpty())
			throw new IDnotFoundException("Patron ID not exist");
		
		boolean Status = borrowService.Status(bookId, patronId);
		
		if(Status)
			throw new Exception("Already Borrowed");
			
		
		Borrow bor = new Borrow();
		
		bor.setId(0);
		bor.setBookID(bookId);
		bor.setPatronID(patronId);
		bor.setBorrowDate(LocalDateTime.now());
		bor.setReturnDate(null);
		borrowService.addBorrow(bor);
		return bor;
	}

	@PutMapping("/return/{bookId}/patron/{patronId}")
	Borrow returnBorrows(@PathVariable int bookId,@PathVariable int patronId) throws Exception
	{
		Optional<Book> book_status = bookService.getBook(bookId);
		Optional<Patron> patron_status = patronService.getPatron(patronId);
		
		if(book_status.isEmpty())
			throw new IDnotFoundException("Book ID not exist");
		else if( patron_status.isEmpty())
			throw new IDnotFoundException("Patron ID not exist");
		
		boolean Status = borrowService.Status(bookId, patronId);
		
		if(!Status)
			throw new Exception("Book is not borrowed by this patron");
		
		boolean returnStatus = borrowService.returnStatus(bookId, patronId);
		
		if(returnStatus)
			throw new Exception("Book is alreay returned");
		
		return borrowService.returnBorrow(bookId,patronId);
	}
}