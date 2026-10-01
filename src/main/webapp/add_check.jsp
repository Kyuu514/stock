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
		登録内容は以下で間違いないですか？<br>
		氏名：<%=session.getAttribute("name") %><br>
		<%
			String password = (String)session.getAttribute("password");
			String mask = "";
			for(int i = 0; i < password.length(); i++){
				mask += "・";
			}
		%>
		パスワード：<%=mask %><br>
		<form action = "user-add-servlet" method = "POST">
			パスワード：<input type = "password" name = "checkpass"><br>
			<%
				request.setCharacterEncoding("UTF-8");
				String mes = (String)request.getAttribute("mes");
				if(mes != null){
			%>
				<%=mes %><br>
			<%
				}
			%>
			<input type = "submit" value = "登録する">
		</form>
		<form action = "user_add.jsp">
			<input type = "submit" value = "戻る">
		</form>
		<a href = "logout-servlet">ログイン画面</a>に戻る
	</body>
</html>