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
    <table align="center"  width="1000" border="1">            		
        <tr>
			<td align="center" bgcolor="yellow">
				<form action ="${ctx}/AllReaderFind" method = "post">
 				 <input type="submit" value="显示所有用户信息" 
 				 style="width='50px';height='30px';line-height='30px';display:block;margin:10px auto;"> 
 				 </form>
			</td>
		</tr>
    </table>    
	<table align="center" width="1000" border="1" height="120"  bgcolor="white" cellpadding="1" cellspacing="1">
		
		<tr align="center" bgcolor="#e1ffc1">
			<td><b>类      别</b></td>		 
			<td><b>用户名</b></td>
			<td><b>性别</b></td>
			<td><b>年龄</b></td>
			<td><b>班级/部门</b></td>
			<td><b>学号/工号</b></td>
			<td><b>电话号码</b></td>
			<td><b>借阅数量</b></td>
			<td><b>可借数量</b></td>
		</tr>
		<c:forEach items="${requestScope.list}" var="r">
			<tr align="center" bgcolor="white">
				<td>${r.getrSort()}</td>
				<td>${r.getrName()}</td>
				<td>${r.getrsex()}</td>
				<td>${r.getrage()}</td>				
				<td>${r.getrClass()}</td>
				<td>${r.getrNo()}</td>
				<td>${r.getrPhoneNum()}</td>
				<td>${r.getLendNum()}</td>
				<td>${r.getCanLendNum()}</td>
			</tr>			
		</c:forEach>			
	</table>	
 </body>
</html>