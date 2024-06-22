package max.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		out.println("<html><body>");
		out.println("<div id='logout' align='center' style='background-color:lightblue'><h3>LogOut Successfully..."+email+"</h3></div> ");
		out.println("<div id='loginagain' align='right'><a href=login.html>Login Again...</a></div>");
		out.println("</body></html>");
	    //out.println("logout "+email);
	     
	}

}
