package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "borrowing_record")
public class Borrow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "patronid")
	private int PatronID;
	@Column(name = "bookid")
	private int BookID;
	
	@Column(name = "return date")
	private LocalDateTime returnDate;
	
	@Column(name = "borrow date")
	private LocalDateTime borrowDate;
	
	public Borrow(){}

	public Borrow(int patronID, int bookID, LocalDateTime returnDate, LocalDateTime borrowDate) {
		super();
		PatronID = patronID;
		BookID = bookID;
		this.returnDate = returnDate;
		this.borrowDate = borrowDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatronID() {
		return PatronID;
	}

	public void setPatronID(int patronID) {
		PatronID = patronID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(LocalDateTime borrowDate) {
		this.borrowDate = borrowDate;
	}

	@Override
	public String toString() {
		return "Borrow [id=" + id + ", PatronID=" + PatronID + ", BookID=" + BookID + ", returnDate=" + returnDate
				+ ", borrowDate=" + borrowDate + "]";
	}
	
	
	
}
