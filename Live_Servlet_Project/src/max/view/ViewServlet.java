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


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		List<String> list = RegisDAO.getRecords();
		
		out.println("<html><body>");
	       out.println("<form action ='ViewRecords'>");
	       out.println("<table border='3' bgcolor='yellow'align='center' >");
out.println("<tr><td >   Select Email  </td>");
out.println("<td>");
out.println("<select name='email'>");
out.println("<option value= All>ALL </option> ");
		for(String p:list){


out.println("<option value="+p+"> "+p+"> </option> ");
		
		}
	       
		 out.println("  </select> </td></tr>");
	          
		 out.println("<tr><td align='center'><input type ='submit' value='View' ></td></tr>");
		 
	       out.println("</table></form></body></html>");
	
		
	      
	       
	
	}

}
