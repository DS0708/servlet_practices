<%@page import="com.bitacademy.emaillist.vo.EmaillistVo"%>
<%@page import="com.bitacademy.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String firstName = request.getParameter("fn");
	String lastName = request.getParameter("ln");
	String email = request.getParameter("email");
	
	EmaillistDao dao = new EmaillistDao();
	
	EmaillistVo vo = new EmaillistVo();
	vo.setFirstName(firstName);
	vo.setLastName(lastName);
	vo.setEmail(email);
	
	dao.insert(vo);
	
	response.sendRedirect("/emaillist01/");			//f5 눌러서 계속 데이터베이스에 삽입 하는 것 방지
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="/emaillist01/">리스트 확인</a>
</body>
</html>