package max.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		   HttpSession s = request.getSession(false);
		     String email=(String)s.getAttribute("email");
		     System.out.println("email "+email);
	       out.println("<html><body>");
	       
	       out.println("<table border='3' bgcolor='yellow'align='center' >");
 out.println("<tr><td colspan='2' align='right'><a href=LogoutServlet?email="+email+">"+email+"   </a>  </td></tr>");
		   
	       
	       out.println("<tr><td><a href='ViewServlet'> View</a>   </td></tr>");
	       out.println("<tr><td><a href='delete'> Delete</a>   </td></tr>");
		    
	       out.println("<tr><td><a href='update.html'> Update</a>   </td></tr>");
		    
	          
	       out.println("</table></body></html>");
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
