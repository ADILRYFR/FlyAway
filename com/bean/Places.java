package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Places {
	@Id
	@OneToOne
	private int Pid;
	@OneToOne
	private String Source;
	@OneToOne
	private String Destination;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public Places(int pid) {
		super();
		Pid = pid;
	}
	public Places() {
		super();
	}
	
	
	
	

}
