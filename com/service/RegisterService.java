package com.service;

import java.util.List;

import com.Dao.RegisterDao;
import com.bean.Flight;
import com.bean.Places;

public class RegisterService {
RegisterDao rd = new RegisterDao();


  public List<Flight> getFlights(String d, String s ,String date){
	  
	  return rd.getListOfairlinesingivendate(d,s,date);
	  
	  
  }


  public Flight getFlight(int id) {
	 return rd.getFlightDetails(id);
	 
  }
}
