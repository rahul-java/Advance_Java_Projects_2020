package max.delete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisDAO;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
		 String email = request.getParameter("email");
		 
		 List<String> list = RegisDAO.getRecords();
			
			out.println("<html><body>");
			out.println("<div align='center' bgcolor='skyblue'><h2> Delete Records</h2></div>");
			out.println("<br><br>");
		       out.println("<form action ='DeletedMsgServlet'>");
		       out.println("<table border='3' bgcolor='yellow'align='center' >");
	out.println("<tr><td >   Select Email  </td>");
	out.println("<td>");
	out.println("<select name='email'>");
	out.println("<option value= All>ALL </option> ");
			for(String p:list){


	out.println("<option value="+p+"> "+p+"> </option> ");
			
			}
		       
			 out.println("  </select> </td></tr>");
		          
			 out.println("<tr><td align='center'><input type ='submit' value='Delete' ></td></tr>");
			 
		       out.println("</table></form></body></html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
