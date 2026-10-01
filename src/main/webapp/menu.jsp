<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>メニュー</title>
	</head>
	<body>
		<jsp:include page = "header.jsp"></jsp:include>
		<%
			String role = (String)session.getAttribute("role");
		%>
		<h1>メニュー</h1>
		<form action = "menu-servlet" method = "POST">
			<button type = "submit" name = "url" value = "show-stock-servlet">在庫表示</button><br>
			<button type = "submit" name = "url" value = "add-stock-servlet">在庫登録</button><br>
			<button type = "submit" name = "url" value = "show-shotageList-servlet">不足リスト表示</button><br>
			<button type = "submit" name = "url" value = "add-buyList-servlet">買い物リスト作成</button><br>
			<button type = "submit" name = "url" value = "show-buyList-servlet">買い物リスト表示</button><br>
			<%
				if(role.equals("2")){
			%>
				<button type = "submit" name = "url" value = "show-user-servlet">ユーザー情報表示</button><br>
				<button type = "submit" name = "url" value = "show-userStock-servlet">ユーザー在庫表示</button><br>
			<%
				}else{
			%>
			<br><br>
			<%
				}
			%>
			<button type = "submit" name = "url" value = "belete-servlet">ユーザー情報削除</button><br>
		</form>
		<br>
		<jsp:include page = "footer.jsp"></jsp:include>
	</body>
</html>