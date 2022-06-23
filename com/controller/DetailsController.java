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
import com.bean.Passengers;
import com.service.PassengerService;

/**
 * Servlet implementation class DetailsController
 */
public class DetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    PassengerService ps = new PassengerService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		HttpSession htp = request.getSession();
		
		List<Passengers> list = ps.getAllPassengers();
		Flight fl = (Flight) htp.getAttribute("flight");
		
		Long price = fl.getTicket_price();
		System.out.println("price is"+price);
		System.out.println("list size is"+list.size());
		
		
		price = price*list.size();
		System.out.println("the new price for the ticket is:"+price);
		fl.setTicket_price(price);
		System.out.println("the price in the shit was"+fl.getTicket_price());
		
		htp.setAttribute("flight", fl);
		htp.setAttribute("list", list);
	//	htp.setAttribute("price",price);
		RequestDispatcher rd = request.getRequestDispatcher("ConfirmationPage.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
       String name = request.getParameter("name");
       Long number = Long.parseLong(request.getParameter("tel_phone"));
       String email = request.getParameter("email");
       
       Passengers p = new Passengers();
       p.setEmail(email);
       p.setName(name);
       p.setNumber(number);
       
       if(ps.addPassenger(p)) {
    	   
    	   RequestDispatcher rd = request.getRequestDispatcher("EnterDetails.jsp");
    	   pw.println("Passenger added");
    	   rd.include(request, response);
    	   
       }
       
       
		
		
		
		
	}

}
