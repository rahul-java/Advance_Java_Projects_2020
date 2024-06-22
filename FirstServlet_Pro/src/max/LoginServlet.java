package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/lgn")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
		PrintWriter out = response.getWriter();
		String uid = request.getParameter("ud");
		String pass=  request.getParameter("pass");
		out.println("First Servlet "+uid+ " "+pass);
		if(uid.equalsIgnoreCase(pass))
		{
			
		HttpSession s = request.getSession();
		      s.setAttribute("ud", uid);
		      
		      
		      
request.getRequestDispatcher("SecondServlet").forward(request, response);


		}
		else
		{
request.getRequestDispatcher("ThirdServlet").include(request, response);
	
		}
		
	}

}
