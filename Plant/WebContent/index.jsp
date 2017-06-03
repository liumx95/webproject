<%@ page language="java" import="com.domain.*"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主界面</title>
</head>
<body>
<%
	AppUser user=(AppUser)request.getAttribute("u");
 
  if(user==null){
%>
	  	 <a href="login.jsp">登录</a>
	  	 <a href="reg.jsp">注册</a>
	 <%}else{ 
		 out.print(user.getUname()+"您好，欢迎使用本网站");
		
	 } %> 
</body>
</html>