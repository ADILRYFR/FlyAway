package com.service;

import java.util.List;

import com.Dao.UserDao;
import com.bean.User;

public class LoginService {
	UserDao ud = new UserDao();
	public boolean checkUser(String id,String pass) {
		if(ud.checkUser(id, pass)) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	public boolean createUser(User user) {
		if(ud.createUser(user)) {
			System.out.println("Check");
			return true;
		}else {
			System.out.println("Check but wrong");
			return false;
			
		}
	}

}
