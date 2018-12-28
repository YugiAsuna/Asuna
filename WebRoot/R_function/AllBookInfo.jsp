<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="testSession.jsp"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFCC">
    <table align="center"  width="1100" border="1">       
        <tr>
			<td align="center" bgcolor="yellow">
				 <form action ="${ctx}/AllBookFind" method = "post">
 				 <input type="submit" value="显示所有图书" 
 				 style="width='50px';height='30px';line-height='30px';display:block;margin:10px auto;"> 
 				 </form>
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
		</tr>
		<c:forEach items="${requestScope.list}" var="b">
			<tr align="center" bgcolor="white">
			    <td>${b.getBarCode()}</td>
				<td>${b.getbName()}</td>
				<td>${b.getWriter()}</td>
				<td>${b.getPress()}</td>
				<td>${b.getPresstime()}</td>				
				<td>${b.getPageNum()}</td>
				<td>${b.getPrice()}</td>
				<td>${b.getSort()}</td>		
			</tr>
		</c:forEach>
	</table>	
 </body>
</html>