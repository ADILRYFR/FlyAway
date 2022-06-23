<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%Object obj = session.getAttribute("flight"); %>
<%session.setAttribute("flight",obj); %>




<div align="center">
<form action="DetailsController" method="post">
<p id="txt">Enter the Passenger's Name</p>
<input type="text" name="name" id ="name"><br><br>
<p id="txt">Enter the Passenger's Phone Number</p>
<input type="number" name="tel_phone" id ="tel">
<p id="txt">Enter the Passenger's Email</p>
<input type="email" name="email" id ="email">
<input type="submit" value="add">

</form>
<br>
<br><br>

<form action="DetailsController" method="get">
<label>Make sure you add passenger details and then press Submit</label><br>
<input type="submit" value="submit">
</form>
</div>





</body>
</html>