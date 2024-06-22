<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <jsp:useBean id="ubean" class="max.UserBean"/>
    
    <jsp:setProperty name="ubean" property="*"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%

       if(ubean.getUserDetails())
       {
    	   request.getRequestDispatcher("index.jsp").forward(request, response);
       }
       else
       {  out.println("Erroorr");
    	   request.getRequestDispatcher("index.jsp").include(request, response);
       }
%>

</body>
</html>