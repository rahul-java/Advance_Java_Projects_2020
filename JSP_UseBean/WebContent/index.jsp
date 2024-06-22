<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        
        <form action="process.jsp">
        
        <table border="4" bgcolor="yellow" align="center">
        <tr><th bgcolor="skyblue">U Name</th><td><input type="text" name="name"></tr>
          <tr><th bgcolor="skyblue">pass</th><td><input type="password" name="pass"></tr>
        <tr><th bgcolor="skyblue">Email</th><td><input type="text" name="email"></tr>
          <tr><th bgcolor="skyblue">Phone</th><td><input type="number" name="phone"></tr>
        
          <tr><td><input type="submit"></td><td>
          
          <a href="view.jsp">View</a>
          </td></tr>
        
        </table>
        
        </form>
</body>
</html>