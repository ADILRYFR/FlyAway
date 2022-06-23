package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.service.LoginService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    LoginService ls = new LoginService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		System.out.println("Check in login controller");
		RequestDispatcher rd = request.getRequestDispatcher("Signin.jsp");
		RequestDispatcher rd1 = request.getRequestDispatcher("Signup.jsp");
		String username = request.getParameter("id");
		String password = request.getParameter("pass");
		
		User us = new User();
		us.setPassword(password);
		us.setUser(username);
		
		if(ls.createUser(us)) {
			System.out.println("Check over here");
			pw.println("Account was created");
			pw.println("...You should be able to log in to your account now");
			rd.include(request, response);
		}else {
			System.out.println("Check over else");
			pw.println("Account was not created");
			rd1.include(request, response);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession htp = request.getSession();
		
		String username = request.getParameter("id");
		htp.setAttribute("user", username);
		String password = request.getParameter("pass");
		System.out.println("password is"+password+"|");
		
		User us = new User();
		us.setPassword(password);
		us.setUser(username);
	    
		
		if(ls.checkUser(username, password)) {
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		}else {
			pw.println("Wrong Credentials");
			RequestDispatcher rd1 = request.getRequestDispatcher("Signin.jsp");
			rd1.include(request, response);
				
			
		}
		
	}

}
