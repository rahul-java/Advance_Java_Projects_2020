package max.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.reg.RegisBean;
import max.reg.RegisDAO;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		     PrintWriter out = response.getWriter();
		     HttpSession s = request.getSession(false);
		     String email=(String)s.getAttribute("email");
		     List<RegisBean> list = RegisDAO.getRecords(email);
		     
		     //System.out.println("email "+email);
	       out.println("<html><body>");
	       for(RegisBean rb:list)
	       {
	       out.println("<div id='loginwelcome' align='center' style='background-color:green'><h1>Welcome Mr./Mrs. "+rb.getName()+"</h1></div>");
	       }
	       out.println("<div id='logout' align='right' ><h3>LogOut :<a href=LogoutServlet?email="+email+">"+email+"   </a></h3></div>");
	       out.println("<table border='3' bgcolor='yellow' align='center' style='width:20%'>");
           //out.println("<tr><td colspan='2' align='right'><a href=LogoutServlet?email="+email+">"+email+"   </a>  </td></tr>");
	       out.println("<tr><td><a href='ViewServlet'> View</a>   </td></tr>");
	       out.println("<tr><td><a href='DeleteServlet?email="+email+"'> Delete</a>   </td></tr>");
	       out.println("<tr><td><a href='UndoDeleteServlet?email="+email+"'> UndoDelete/RecoverAll</a></td></tr>");
		   out.println("<tr><td><a href='Update.html?email="+email+"'> Update</a>   </td></tr>");
		   out.println("</table></body></html>");
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
