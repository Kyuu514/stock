<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ユーザー登録</title>
	</head>
	<body>
		<jsp:include page = "header.jsp"></jsp:include>
		<h1>ユーザー登録</h1>
		<%
			String mes = (String)request.getAttribute("mes"); 
			if(mes != null){
		%>
			<%=mes %><br>
		<%
			}
		%>
		<form action = "add-check-servlet" method = "POST">
			名前：<input type = "text" name = "name"><br>
			パスワード：<input type = "password" name = "password"><br>
			<input type = "submit" value = "登録する">
		</form>
		<br>
		<a href = "login.jsp">ログイン</a>に戻る
	</body>
</html>