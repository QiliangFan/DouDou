<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="./css/manager.css">
<title>manager</title>
</head>
<%
	String authority=(String)session.getAttribute("authority");
	String email=(String)session.getAttribute("email");
	if(email==null||email.equals("")){
		response.sendRedirect("main.jsp");
	}
	else if(authority==null||authority.equals("0")){
		response.sendRedirect("main.jsp");
	}
%>
<frameset rows="20%,80%">
		<frame src="mhead.jsp">
		<frameset cols="20%,80%">
			<frame src="mleft.jsp">
			<frame src="mright.jsp" name="rights">
		</frameset>
</frameset>
<body>

</body>
</html>