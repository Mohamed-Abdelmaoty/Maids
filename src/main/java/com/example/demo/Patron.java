package com.example.demo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patron")
public class Patron {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "contact information")
	private String contact_info;
	
	@Column(name = "Gender")
	private String Gender;
	
	@Column(name = "Join Date")
	private LocalDateTime joinDate;

	public Patron() {}
	public Patron(String name, String contact_info, String gender, LocalDateTime joinDate) {
		super();
		this.name = name;
		this.contact_info = contact_info;
		Gender = gender;
		this.joinDate = joinDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact_info() {
		return contact_info;
	}
	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "Patron [id=" + id + ", name=" + name + ", contact_info=" + contact_info + ", Gender=" + Gender
				+ ", joinDate=" + joinDate + "]";
	}
	
	
	
}
