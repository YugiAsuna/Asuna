<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body bgcolor="#FFFFCC">
    <table align="center"  width="1100" border="1">
        <tr>
			<td align="left" bgcolor="gree">
				<a href="R_function/BookSeek.jsp">返回上一级</a>
			</td>
		</tr>
        <tr>
			<td align="center" bgcolor="yellow">
				<h1>搜索图书信息</h1>
			</td>
		</tr>
    </table>    
	<table align="center" width="1100" border="1" height="120"  bgcolor="blue" cellpadding="1" cellspacing="1">
		
		<tr align="center" bgcolor="#e1ffc1">
		    <td><b>条形码</b></td>			 
			<td><b>图书名称</b></td>
			<td><b>作     者</b></td>
			<td><b>出 版 社</b></td>
			<td><b>出版时间</b></td>
			<td><b>页      数</b></td>
			<td><b>价      格</b></td>
			<td><b>类      别</b></td>
			<td><b>借阅次数</b></td>
			<td><b>借阅状态</b></td>
		</tr>
		<c:forEach items="${requestScope.list}" var="b">
			<tr align="center" bgcolor="white" >
			    <td>${b.getBarCode()}</td>
				<td>${b.getbName()}</td>
				<td>${b.getWriter()}</td>
				<td>${b.getPress()}</td>
				<td>${b.getPresstime()}</td>				
				<td>${b.getPageNum()}</td>
				<td>${b.getPrice()}</td>
				<td>${b.getSort()}</td>
				<td>${b.getLendNum()}</td>
				<td>${b.getState()}</td>
			</tr>
		</c:forEach>
	</table>	
 </body>
</html>