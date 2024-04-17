package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("SELECT e FROM Book e WHERE e.title IN (:tite)")
    Book findByTitle(@Param("tite") String tite);
	
	@Query("SELECT e FROM Book e WHERE e.ISBN IN (:isb)")
    Book findByISBN(@Param("isb") String isb);
}

