<%@page import="com.bean.Flight"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying Flights</title>
</head>
<body>

<form action="RegisterController" method="get">
<table BORDER="2">
<tr>
<th>Flight_no.</th>
<th>Source</th>
<th>Destination</th>
<th>Price</th>
<th>Airline</th>
<
</tr>


<%
Object obj = session.getAttribute("listofFlights");
if(obj!=null){
	List<Flight> listOfProduct = (List<Flight>)obj;
	out.println("yes");
	Iterator<Flight> it =  listOfProduct.iterator();
	while(it.hasNext()){
		Flight p = it.next();
		%>
		<tr>
		<td><%=p.getFid() %></td>
		<td><%=p.getSource() %></td>
		<td><%=p.getDestination() %></td>
		<td><%=p.getTicket_price()%></td>
		<td><%=p.getAirline() %></td>

		</tr>
		
		
		<%
		
		
		
	}
	
}
%>
</table>
<br><br>
<label>Which Flight_no do you wish to proceed with?</label>
<input type="number" name ="id">
<input type="submit" value="submit">
</form>



</body>
</html>