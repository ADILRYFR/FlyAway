package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


import com.bean.Passengers;

public class PassengerDao {

	
	public int addPassenger(Passengers p) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Mrin");
			
		    
			PreparedStatement pstmt = con.prepareStatement("insert into Passengers values(?,?,?)");
			pstmt.setString(1, p.getName() );
			pstmt.setFloat(2, p.getNumber());
			pstmt.setString(3,p.getEmail());
			int result = pstmt.executeUpdate();
			return result;
			
			
		}catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
public List<Passengers> getPassengers() {
		

	Configuration con = new Configuration();
	con.configure("hibernate.cfg.xml");
	SessionFactory sf = con.buildSessionFactory();
	Session session= sf.openSession();
    Query qry = session.createQuery("select emp from Passengers emp");
    List <Passengers> listOfEmp = qry.list();
	return listOfEmp;
		
	}
	
	
	public PassengerDao() {
		// TODO Auto-generated constructor stub
	}

}
