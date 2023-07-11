<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="join.jsp" method="post">
		<label>email:</label> <input type="text" name="email"> <br>
		<label>password:</label> <input type="text" name="password"> <br>
	
	<br><br>
	<label>생년:</label>
	<select name="birthYear">
		<option value="2000">2000년</option>
		<option value="2001">2001년</option>
		<option value="2002">2002년</option>
	</select>
	
	<br><br>
	<label>gender:</label>
	female<input type="radio" name="gender" value="female" checked="checked">
	male<input type="radio" name="gender" value="male">
	
	<br><br>
	<label>자기소개:</label>
	<textarea name="profile"></textarea>
	
	<br><br>
	<label>hobby:</label>
	<input type="checkbox" name="hobby" value="coding"> coding
	<input type="checkbox" name="hobby" value="game"> Game
	<input type="checkbox" name="hobby" value="exercise"> exercise
	<input type="checkbox" name="hobby" value="drinking"> drinking
	
	
	<br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>