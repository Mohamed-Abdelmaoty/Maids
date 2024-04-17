package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatronService {

	@Autowired
	PatronRepository patronRep;
	
	List<Patron> getAllPatrons()
	{
		return patronRep.findAll();
	}
	
	Optional<Patron> getPatron(int id)
	{
		return patronRep.findById(id);
	}
	
	Patron addPatron(Patron patron)
	{
		return patronRep.save(patron);
	}
	
	void deletePatron(int id)
	{
		patronRep.deleteById(id);
	}
}
