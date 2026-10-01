<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>在庫管理</h1>
<% 
	if(session.getAttribute("user_id") != null){
%>
ユーザーID：<%=session.getAttribute("user_id") %>	
氏名：<%=session.getAttribute("name") %>
<%
	}else{
%>
<br>
<%
	}
%>