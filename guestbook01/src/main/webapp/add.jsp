<%@page import="com.bitacademy.guestbook.dao.GuestBookDao"%>
<%@page import="com.bitacademy.guestbook.vo.GuestBookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String text = request.getParameter("message");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setText(text);
	
	GuestBookDao dao = new GuestBookDao();
	dao.insert(vo);
	
	response.sendRedirect("/guestbook01/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%=vo.getName() %></h1>
	<h1><%=vo.getPassword() %></h1>
	<h1><%=vo.getText() %></h1>
</body>
</html>