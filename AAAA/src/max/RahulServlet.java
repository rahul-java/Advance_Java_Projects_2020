package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/rahul")
public class RahulServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String e=request.getParameter("email");
		String n=request.getParameter("mobile");
		
		HttpSession session = request.getSession();
		session.setAttribute("email", e);
		session.setAttribute("mobile", n);
		
		out.println("Login Successful.......");
		
		out.println("Email id : "+e+" Mobile :"+n);
		out.println("<a href='./logout'>Logout</a>");
	}

}
