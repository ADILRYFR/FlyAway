package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Flight;
import com.bean.NoofPassengers;
import com.bean.Places;
import com.service.RegisterService;

/**
 * Servlet implementation class RegisterController
 */
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   RegisterService rs = new RegisterService();
   NoofPassengers pas = new NoofPassengers();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());s
		int id = Integer.parseInt(request.getParameter("id"));
		rs.getFlight(id);
		HttpSession htp = request.getSession();
		htp.setAttribute("no.ofpas", pas.getNo_ofpassengers());
		htp.setAttribute("flight", rs.getFlight(id));
		RequestDispatcher rd = request.getRequestDispatcher("EnterDetails.jsp");
		rd.include(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		PrintWriter pw = response.getWriter();
		String Source = request.getParameter("source");
		String Destination = request.getParameter("destination");
		String Date = request.getParameter("date");
	    int no_pas = Integer.parseInt(request.getParameter("no.passengers"));
	    
	    pas.setNo_ofpassengers(no_pas);
		System.out.println(Date);
		HttpSession htp = request.getSession();
		
		Places pl = new Places();
		pl.setDestination(Destination);
		pl.setSource(Source);
		
		List<Flight>list =rs.getFlights(Destination,Source, Date);
		htp.setAttribute("listofFlights",list);
		htp.setAttribute("source", Source);
		htp.setAttribute("Destination", Destination);
		RequestDispatcher rd = request.getRequestDispatcher("DisplayFlights.jsp");
		rd.include(request, response);
		
		
		
		
				
		
		
	}

}
