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
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");

		String email=request.getParameter("email");
		//String mobile=request.getParameter("mobile");
		UserBean user=User.getUserDetail(email);
		
		out.println("Login Successful.......");
		out.println("Welcome Mr./Mrs."+user.getName());
		out.println("Email id : "+user.getEmail()+"\n Mobile :"+user.getMobile()+"\n Password :"+user.getPassword());
		
		HttpSession session = request.getSession();
		session.setAttribute("email", user.getEmail());
		session.setAttribute("mobile", user.getEmail());
		session.setAttribute("password", user.getPassword());
		session.setAttribute("name", user.getName());
		out.println("<a href='logout'>Logout</a>");
		
	}

}
