<%@ page language="java" isErrorPage="true"%>
<%@page import="java.io.PrintStream"%>
<html>
<head>
<title>系统错误</title>
</head>
<body>
<%
	String debug = (String)request.getSession().getAttribute("isDebug"); 
	if("1".equals(debug)){
%>
		<%=exception%><br>
		<%=exception.getMessage()%><br>
		<%=exception.getLocalizedMessage()%><br>
		<%
			exception.printStackTrace(new java.io.PrintWriter(out));
		%>
<%
	}
	else{
%>
	系统错误, 请联系管理员。
<%
	}
%>

</body>
</html>