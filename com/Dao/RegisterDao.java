package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.bean.Flight;
import com.bean.Places;
import com.resource.Resource;

public class RegisterDao {
	
	public List<Flight> getListOfairlinesingivendate(String D,String S,String Date) {
		
	    SessionFactory sf = Resource.getConnection();
	    Session session = sf.openSession();
	   
	    String[] dat= Date.split("-");
	    int length = dat.length;
	    
	    String data = dat[2]+"-"+dat[1]+"-"+dat[0];
	    System.out.println(data);
	  
	    System.out.println(D);
	    System.out.println(S);
	  	    
	    Query qry = session.createQuery("select fl from Flight fl where fl.Date =:date and fl.Source=:s and fl.Destination = :d");
	    qry.setParameter("date", data);
	    qry.setParameter("s", S);
	    qry.setParameter("d", D);
	    List<Flight> list = qry.list();
	    
	    
	    return list;
		}
	
	public Places getplaces(String Destination,String source){
		
//		
//		 SessionFactory sf = Resource.getConnection();
//		    Session session = sf.openSession();
//		    
//		    Query qry = session.createQuery("select sd.Pid from Places sd where sd.Destination=:dest and sd.Source=:src");
//		    qry.setParameter("dest", Destination);
//		    qry.setParameter("src",source);
//		    List<Places> list = qry.list();
//		    return list;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university_batch", "root", "Mrin");
			
		    
			PreparedStatement pstmt = con.prepareStatement("select * from Places where Destination =? and Source =?");
			pstmt.setString(1, Destination);
			pstmt.setString(2, source);
			ResultSet rs = pstmt.executeQuery();
			Places pl = new Places();
			if(rs.next()) {
				
				pl.setPid(rs.getInt(1));
			}
			return pl;
			
			}catch(Exception e) {
				System.out.println(e);
				e.printStackTrace();
			}
		return null;
	}
	
	public Flight getFlightDetails(int id) {
		

	    SessionFactory sf = Resource.getConnection();
	    Session session = sf.openSession();
	  
	  
	    Flight fl = session.get(Flight.class,id);
	    
	    
	    return fl;
		
	}

}
