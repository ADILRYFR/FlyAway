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
<br><br>
Enter your details
<br>
<form  action="LoginController" action="get">
<label>Username/Email Id</label>
<input type="text" name ="id">
<br>
<label>Password</label>
<input type="text" name ="pass">
<br>
<input type="submit" value ="Submit">
<input type="reset" value ="reset">
</form> 
<br>
<a href="Signin.jsp">Login</a>
</div>

</body>
</html>