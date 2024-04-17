package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@Column(name = "title")
    private String title;
	@Column(name = "author")
    private String author;
	
	@Column(name = "publication year")
	private LocalDateTime PublishYear;
	@Column(name = "ISBN")
	private String ISBN;
	@Column(name = "price")
	private int price;
	@Column(name = "Insertion date")
	private LocalDateTime InsertionDate;
	
	
	public Book(){}
	
	
	public Book(String title, String author, LocalDateTime publishYear, String iSBN, int price,
			LocalDateTime insertionDate) {
		super();
		this.title = title;
		this.author = author;
		PublishYear = publishYear;
		ISBN = iSBN;
		this.price = price;
		InsertionDate = insertionDate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDateTime getPublishYear() {
		return PublishYear;
	}
	public void setPublishYear(LocalDateTime publishYear) {
		PublishYear = publishYear;
	}
	public LocalDateTime getInsertionDate() {
		return InsertionDate;
	}
	public void setInsertionDate(LocalDateTime insertionDate) {
		InsertionDate = insertionDate;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", PublishYear=" + PublishYear + ", ISBN="
				+ ISBN + ", price=" + price + ", InsertionDate=" + InsertionDate + "]";
	}
	
	
	
	
	
	
	
}
