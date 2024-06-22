package max.delete;

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

@WebServlet("/DeletedMsgServlet")
public class DeletedMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		PrintWriter out = response.getWriter();  
		
	    out.println("<html><body>");
	    
		if(RegisDAO.deleteRecords(email))
		{
			out.println("<div id='SuccessMsg' style='background-color:green' align ='center'><h2>Deleted Successfully...</h2></div>");
			out.println("<br><br>");
		}
		else
		{
			System.out.println("<div id='ErrorMsg' style='background-color:green' align ='center'><h2>Error Record not found in the database...</h2></div>");
			out.println("<br><br>");
		}
		out.println("");
		
		 out.println("<br>");
	     out.println("<div id='buttons'><table align='center'style='width:100%'><tr><td align='center' width='30%'><a href='DeleteServlet?email="+email+"'><h3> Back</h3></a></td>");
	     out.println("<td align='center' width='30%'><a href='WelcomeServlet?email="+email+"'><h3> Home</h3></a></td>");
	     out.println("<td align='center' width='30%'><a href='UndoDeleteServlet?email="+email+"'><h3> UndoDelete/Recover All</h3></a></td>");
	     out.println("</tr></table></div></body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
