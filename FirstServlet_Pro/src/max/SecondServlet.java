package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
	    
		String uid = request.getParameter("ud");
		String pass=  request.getParameter("pass");
		
		HttpSession s = request.getSession(false);
		 String d=(String)s.getAttribute("ud");
		
		out.println("session "+d);
		out.println("Second Servlet "+uid+ " "+pass);
		
		out.println("<a href=FourServlet?ud="+uid+">Nexttttt</a>");
		
	}

}
