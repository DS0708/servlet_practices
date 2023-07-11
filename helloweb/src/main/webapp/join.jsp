<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");				//한글깨짐 현상 방지 
	
	String email = request.getParameter("email");		//receive data
	String pass = request.getParameter("password");
	String birthYear = request.getParameter("birthYear");
	String gender = request.getParameter("gender");
	String profile = request.getParameter("profile");
	String[] hobbies = request.getParameterValues("hobby");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5><%=email %></h5>
	<h5><%=pass %></h5>
	<h5><%=birthYear %></h5>
	<h5><%=gender %></h5>
	<h5><%=profile.replaceAll("\n","<br>") %></h5>
	
	<%
		for(String hobby : hobbies) {
	%>
		<h4><%=hobby %></h4>
	<%
		}
	%>
</body>
</html>