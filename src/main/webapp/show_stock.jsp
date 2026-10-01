<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.List,model.entity.CategoryBean,model.entity.StockCategoryBean"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>在庫表示</title>
	<style>
		.modal {
			display: none;
			position: fixed;
			top: 0;
			left: 0;

			width: 100%;
			height: 100%;

			background-color: rgba(0, 0, 0, 0.5);
		}

		.modal-content {
		
			background-color: white;
		
			width: 300px;
		
			margin: 150px auto;
		
			padding: 20px;
		
			border: 1px solid black;
		}

</style>
	</head>
	<body>
		<form action = "show_stock.jsp">
			<select name = "category_id">
				<option value = "0">すべて</option>
				<%
					List<CategoryBean>catList = (List<CategoryBean>)session.getAttribute("catList");
					for(CategoryBean catBean : catList){
				%>
						<option value = "<%=catBean.getCategory_id() %>"><%=catBean.getItem_category() %></option>
				<%
					}
				%>
			</select>
			<input type = "submit" value = "絞込">
		</form>
		<%
			String category_id = request.getParameter("category_id");
			int selectCategory = 0;
			if(category_id != null){
				selectCategory = Integer.parseInt(category_id);
			}
		%>
		<%
			for(CategoryBean catBean :catList){
				
				if(selectCategory == 0 || selectCategory == catBean.getCategory_id()){
		%>
				<h1><%=catBean.getItem_category() %></h1>
				<table>
					<tr><th>商品名</th><th>在庫</th><th>操作</th></tr>
					<%
						List<StockCategoryBean>stockList = (List<StockCategoryBean>)session.getAttribute("stockList");
						for(StockCategoryBean stcgBean : stockList){
							if(catBean.getCategory_id() == stcgBean.getCategory_id()){
					%>
							<tr><td><%=stcgBean.getItem_name() %></td><td><%=stcgBean.getItem_count() %></td>
							<td><button type = "button" onclick = "openEdit(<%=stcgBean.getStock_id() %>,<%=stcgBean.getCategory_id() %>,
							'<%=stcgBean.getItem_name() %>',<%=stcgBean.getItem_count() %>,<%=stcgBean.getAlert_count() %>)">編集</button>
							削除</td></tr>
					<%
							}
						}
					%>
		</table>
		<%
				}
			}	
		%>
		<div id = "editModal" class = "modal">
			<div class = "modal-content">
				<h2>商品編集</h2>
				<form action = "update-stock-servlet" method = "POST">
					<input type = "hidden" name = "stock_id" id = "editStockId">
					商品名：<input type = "text" name = "item_name" id = "editItemName"><br>
					カテゴリー：<select name = "category_id" id = "editCategoryId">
						<%
							for(CategoryBean catBean :catList){
						%>
								<option value = "<%=catBean.getCategory_id() %>">
									<%=catBean.getItem_category() %>
								</option>
						<%
							}
						%>
					</select><br>
					在庫数：<input type = "number" name = "item_count" id = "editItemCount"><br>
					在庫警告数：<input type = "number" name = "alert_count" id = "editAlertCount"><br>
					<input type = "submit" value = "更新"><br>
					<button type = "button" onclick = "closeEdit()">キャンセル</button>
				</form>
			</div>
		</div>
		<script>
		
			function openEdit(stock_id, category_id,item_name, item_count, alert_count){
			
				document.getElementById("editStockId").value = stock_id;
				
				document.getElementById("editCategoryId").value = category_id;
			
				document.getElementById("editItemName").value = item_name;
			
				document.getElementById("editItemCount").value = item_count;
			
				document.getElementById("editAlertCount").value = alert_count;
			
				document.getElementById("editModal").style.display = "block";
			}
			
			
			function closeEdit(){
			
				document.getElementById("editModal").style.display = "none";
		
		}
		
		</script>
	</body>
</html>