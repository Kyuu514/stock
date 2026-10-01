<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.CategoryBean"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>在庫登録</title>
	</head>
	<body>
		<h1>在庫登録</h1>
		<form action = "" method = "POST">
			商品名：<input type = "text" name = "item_name"><br>
			カテゴリー：<select name = "category">
				<% 
					List<CategoryBean>catList = (List<CategoryBean>)session.getAttribute("catList");
					for(CategoryBean catBean : catList){
				%>
					<option value = "<%=catBean.getCategory_id()%>"><%=catBean.getItem_category() %></option>
				<%
					}
				%>
			</select><br>
			現在の在庫数：<input list = "numList" name = "item_count">
			<datalist id = "numList">
				<%
				for(int i = 0; i <= 20; i++){ 
				%>
					<option value = <%=i %>><%=i %></option>
				<%
					}
				%>
			</datalist><br>
			通知したい在庫数：<input list = "numList" name = "alert_count">
			<datalist id = "numList">
				<%
				for(int i = 0; i < 20; i++){ 
				%>
					<option value = <%=i %>><%=i %></option>
				<%
					}
				%>
			</datalist><br>
			<input type = "submit" value = "登録する">
		</form>
	</body>
</html>