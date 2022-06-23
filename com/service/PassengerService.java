package com.service;

import java.util.List;

import com.Dao.PassengerDao;
import com.bean.Passengers;

public class PassengerService {

	PassengerDao pd = new PassengerDao();
	
	public boolean addPassenger(Passengers p) {
		if(pd.addPassenger(p)>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public List<Passengers> getAllPassengers(){
		return pd.getPassengers();
	}
	
	public PassengerService() {
		
	}

}
