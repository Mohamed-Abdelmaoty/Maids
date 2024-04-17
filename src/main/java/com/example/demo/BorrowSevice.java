package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class BorrowSevice {

	@Autowired
	BorrowRepository BorrowRep;
	
	@Transactional
	List<Borrow> getAllBorrows()
	{
		return BorrowRep.findAll();
	}
	
	@Transactional
	Optional<Borrow> getBorrow(int id)
	{
		return BorrowRep.findById(id);
	}
	
	@Transactional
	void addBorrow(Borrow Bor)
	{
		BorrowRep.save(Bor);
	}
	
	@Transactional
	Borrow returnBorrow(int book,int patron)
	{
		Borrow temp = BorrowRep.findByIds(book, patron);
		temp.setReturnDate(LocalDateTime.now());
		BorrowRep.save(temp);
		return temp;
	}
	
	boolean Status(int book,int patron)
	{
		Borrow temp = BorrowRep.findByIds(book, patron);
		
		if(temp==null)
			return false;
		
		return true;
	}
	
	boolean returnStatus(int book,int patron)
	{
		Borrow temp = BorrowRep.findByIds(book, patron);
		
		if(temp.getReturnDate()!=null)
			return true;
		
		return false;
	}
}
