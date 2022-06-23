<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
<form action="RegisterController" method="post">
<br><br>
<h2>Enter your travel details</h2>
<br>
<label>From Where:</label>
<input type="text" name="source">
<br><br>
<label>To Where:</label>
<input type="text" name="destination">
<br><br>
<label>Date</label>
<input type="date" name ="date">
<br><br>
<label>How many people are boarding the flight?</label>
<input type="number" name="no.passengers"><br><br>
<input type="submit" value="submit">
<input type="reset" value="reset">
</form>

</div>

</body>
</html>