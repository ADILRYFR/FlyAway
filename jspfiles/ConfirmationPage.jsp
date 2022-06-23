<%@page import="java.util.Iterator"%>
<%@page import="com.bean.Passengers"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.Flight"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Thanks for booking your flight with FlyAway</h3>
<table BORDER="2">
<tr>
<th>Flight no.</th>
<th>From where</th>
<th>To where</th>
<th>The total price for the tickets</th>

</tr>

<%
Object Flight = session.getAttribute("flight");
Flight fl = (Flight)Flight;

 %>
 <tr>
 <td><%= fl.getFid() %>
 <td><%= fl.getSource() %>
 <td><%= fl.getDestination() %>
 <td><%= fl.getTicket_price() %>
 
 </tr>
 
 
</table>


<table BORDER="2">
Passenger Details
<tr>
<th>Passenger's Name</th>
<th>Passenger's Email</th>
<th>Passenger's Telephone no.</th>

</tr>

<%

Object paslist = session.getAttribute("list");
List<Passengers> list = (List<Passengers>)paslist;
Iterator<Passengers> it = list.iterator();
while(it.hasNext()){
	Passengers p = it.next();
 %>
 <tr>
 <td><%= p.getName() %>
 <td><%= p.getEmail() %>
 <td><%=p.getNumber() %>
 
 </tr>
 
 <%
}
%>
</table>

<div>
<label>



</div>

</body>
</html>