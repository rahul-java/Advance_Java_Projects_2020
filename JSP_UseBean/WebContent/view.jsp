<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <jsp:useBean id="udao" class="max.UserDAO"/>
       <%@ page import="java.util.List" %>
       <%@ page import="max.UserBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <table border="4" bgcolor="yellow" align="center">
        <tr><th bgcolor="skyblue">U Name</th><th bgcolor="skyblue">Email</th><th bgcolor="skyblue">Pass</th><th bgcolor="skyblue">Phone</th></tr>
   

      <%
      
      List<UserBean> list=udao.fatchUserDetails();
         for(UserBean p:list)
         {
        	 %>

   <tr>
   <td> <%=p.getName() %> </td>
   <td><%=p.getEmail() %></td>
   <td><%=p.getPass() %></td>
   <td><%=p.getPhone() %></td>
   </tr>
     
     <%
     }
     %>
     
     
</table>



</body>
</html>