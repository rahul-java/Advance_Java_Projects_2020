package max.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisBean;
import max.reg.RegisDAO;

/**
 * Servlet implementation class ViewRecords
 */
@WebServlet("/ViewRecords")
public class ViewRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();   
	 List<RegisBean> l = RegisDAO.getRecords(email);

     out.println("<html><body>");
     
     out.println("<table border='3' bgcolor='yellow'align='center' >");
     out.println("<tr bgcolor='skyblue'><td><h4>   User Name  </h4></td><td><h4>   Email Id  </h4></td><td ><h4>   Phone  </h4></td><td ><h4>   Uid  </h4></td>");

for(   RegisBean p:l)
{
out.println("<tr><td > "+p.getName()+"  </td><td >  "+p.getEmail()+"  </td><td >   "+p.getPhone()+"  </td><td >   "+p.getUid()+"  </td></tr>");
  
}
    
	  
     out.println("</table>");
     out.println("<br>");
     out.println("<div id='buttons'><table align='center'style='width:100%'><tr><td align='center'></td>");
     out.println("<td align='center'><a href='WelcomeServlet?email="+email+"'><h3> Home</h3></a></td>");
     out.println("</tr></table></div></body></html>");
		}

}
