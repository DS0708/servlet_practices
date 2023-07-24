<%@page import="jsplel.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	UserVo vo4 = new UserVo();
	vo4.setNo(4L);
	vo4.setName("duly4");
	pageContext.setAttribute("vo",vo4);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>scope(객체의 존속 범위)</h4>
	
	== Page scope ================ <br>
	${vo.no } <br>
	${vo.name } <br>
	
	== Request scope ================ <br>
	${requestScope.vo.no } <br>
	${requestScope.vo.name } <br>
	
	== Session scope ================ <br>
	${sessionScope.vo.no } <br>
	${sessionScope.vo.name } <br>
	
	== Application scope ================ <br>
	${applicationScope.vo.no } <br>
	${applicationScope.vo.name } <br>
</body>
</html>