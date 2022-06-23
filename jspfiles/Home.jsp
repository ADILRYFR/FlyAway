<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Hello Mr./Ms.<%Object obj = session.getAttribute("user");
           String objf = (String)obj;
           out.println(objf);%></h2>
<a href="Entrypage.jsp">Book a flight</a>

</body>
</html>