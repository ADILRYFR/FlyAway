package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
   @Id
    private int id;
	private String User;
	private String Password;
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
