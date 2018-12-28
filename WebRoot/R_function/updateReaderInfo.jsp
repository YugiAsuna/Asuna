<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ include file="testSession.jsp"%>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#FFFFCC">
   <form name="updateReaderInfo_from" action="${ctx}/UpdateInfo" method="post" target="_self">
      <table align="center" width="600" cellspacing="5px">
			<tr>
				<td align="center" colspan="2">
					<h3>修改密码</h3>
					<hr>
				</td>
			</tr>
			<tr>
				<td  width="160px">用户名：</td>
				<td><c:out value="${NAME}"></c:out></td>
			</tr>
			
			<tr>
				<td width="160px">新密码:</td>
				<td><input type="password" name="newPassword" id="pwd1"/></td>		
			</tr>
			<tr>
				<td width="160px">再次输入新密码:</td>
				<td><input type="password" name="newPassword" id="pwd2" onkeyup="validate()"/><span id="info" style="margin-left:50px"></span></td>		
			</tr>
			<tr>
				<td align="center"  colspan="2">
				<input type="submit" value="确认修改" disabled="false" id="button"" style="margin-top:20px;"> 
				</td>
			</tr>
	     </table>
   </form> 
 <script>
		 function validate() {
 	 		  var pwd1 = document.getElementById("pwd1").value;
  			  var pwd2 = document.getElementById("pwd2").value;
 
<!-- 对比两次输入的密码 -->
  			if(pwd1 == pwd2)
 		   {
     			   document.getElementById("info").innerHTML="<font color='green'>两次密码相同</font>";
      	 document.getElementById("button").disabled = false;
   			  }
			else {
    		    document.getElementById("info").innerHTML="<font color='red'>两次密码不相同</font>";
     			   document.getElementById("button").disabled = true;
     		}
	}
</script>
</body>
</html>