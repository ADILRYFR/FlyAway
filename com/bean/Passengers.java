package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passengers {
    @Id
	private String name;
	private Long number;
	private String Email;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getNumber() {
		return number;
	}


	public void setNumber(Long number) {
		this.number = number;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public Passengers() {
		// TODO Auto-generated constructor stub
	}

}
