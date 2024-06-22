<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/WEB-INF/first.tld" prefix="a" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String n1=request.getParameter("n1");
String n2=request.getParameter("n2");

%>
<a:fr n2="<%=n2 %>" n1="<%=n1 %>"></a:fr>
</body>
</html>