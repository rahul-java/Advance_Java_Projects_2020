<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

    String n= request.getParameter("name");
String p= request.getParameter("pass");
     if(n.equalsIgnoreCase(p))
     {
    	 session.setAttribute("nm", n);
    	 out.println(n + " "+p);
    	 request.getRequestDispatcher("B.jsp").forward(request, response);
     }
     else
     {
    	 response.sendRedirect("index.jsp");
     }
  
%>







</body>
</html>