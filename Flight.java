package com.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Flight {
	  @Id
	    private int Fid;  

		private String Airline;
		private int Pid;
		private String Source;
		private String Destination;
		private Long ticket_price;
		public String getAirline() {
			return Airline;
		}








		public void setAirline(String airline) {
			Airline = airline;
		}








		private String Date;
	    
	    
	    
	    
		


		public String getDate() {
			return Date;
		}








		public void setDate(String date) {
			Date = date;
		}








		public int getFid() {
			return Fid;
		}








		public void setFid(int fid) {
			Fid = fid;
		}















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








		public Long getTicket_price() {
			return ticket_price;
		}








		public void setTicket_price(Long ticket_price) {
			this.ticket_price = ticket_price;
		}







}
