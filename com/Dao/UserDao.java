package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.bean.User;

import com.resource.Resource;

public class UserDao {
	
	public boolean checkUser(String id,String password) {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Mrin");
		PreparedStatement pstst = con.prepareStatement("select * from User where User = ? and Password =?");
		pstst.setString(1, id);
		pstst.setString(2, password);
		ResultSet  rs = pstst.executeQuery();
		if(rs.next()) {
			return true;
		}else {
			return false;
			
		}
		
		
		
	}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
		return false;
	}
	}

	
public boolean createUser(User user) {
		
	try {
		SessionFactory sf = Resource.getConnection();
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(user);
		tran.commit();
		
		
		
		
	}catch(Exception e) {
		System.out.println(e);
		e.printStackTrace();
		return false;
	}
	System.out.println("check");
	return true;
		
	}

	
}
