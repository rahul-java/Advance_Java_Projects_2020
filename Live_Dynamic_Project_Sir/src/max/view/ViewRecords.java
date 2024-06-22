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
out.println("<tr><td >   User Name  </td><td >   email  </td><td >   phone  </td><td >   Uid  </td>");

for(   RegisBean p:l)
{
out.println("<tr><td > "+p.getName()+"  </td><td >  "+p.getEmail()+"  </td><td >   "+p.getPhone()+"  </td><td >   "+p.getUid()+"  </td>");
  
}
    
	  
     out.println("</table></body></html>");

     
     
     
		}

}
