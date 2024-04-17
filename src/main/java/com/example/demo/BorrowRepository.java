package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowRepository extends JpaRepository<Borrow, Integer> {

	@Query("SELECT e FROM Borrow e WHERE e.BookID IN (:id1) and e.PatronID IN (:id2)")
    Borrow findByIds(@Param("id1") int id1, @Param("id2") int id2);
}
