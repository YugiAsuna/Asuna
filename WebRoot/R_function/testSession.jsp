<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
  
  if(session.getAttribute("Uname")==null)
  {
%>
  <h1>未登录！</h1>
        3秒后跳转到登录页面
        <p>
        如果没有跳转，请点<a href="index.jsp">这里</a>
</p>
    <%
        response.setHeader("refresh","3;URL=index.jsp");
        return;
   }
   %>
