<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン</title>
	</head>
	<body>
		<jsp:include page = "header.jsp"></jsp:include>
		<h1>ログイン</h1>
		<form action = "login-servlet" method = "POST">
			ユーザーID：<input type = "text" name = "user_id"><br>
			パスワード：<input type = "password" name = "password"><br>
			<%
				String mes = (String)request.getAttribute("mes");
				if( mes == null){
			%>
				<br>
			<%
				}else{
			%>
				<%=mes %><br>
			<%
				}
			%>
			<input type = "hidden" name = "url" value = "menu.jsp">
			<input type = "submit" value = "ログイン">
		</form>
		新規ユーザー登録は<a href = "user_add.jsp">こちら</a>
	</body>
</html>