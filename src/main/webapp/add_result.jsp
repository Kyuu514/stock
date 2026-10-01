<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>登録結果</title>
	</head>
	<body>
		<jsp:include page = "header.jsp"></jsp:include>
		<h1>登録結果</h1>
		<%request.setCharacterEncoding("UTF-8"); %>
		ユーザーID：<%=request.getAttribute("user_id") %><br>
		氏名：<%=session.getAttribute("name") %><br>
		<%
			String password = (String)session.getAttribute("password");
			String mask = "";
			for(int i = 0; i < password.length(); i++){
				mask += "・";
			}
		%>
		パスワード：<%=mask %><br>
		ユーザーIDはログインに使用するので忘れないようにしてください<br>
		<br>
		<a href = "logout-servlet">ログイン</a>に戻る
	</body>
</html>