package max.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import max.reg.RegisDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		PrintWriter out = response.getWriter();
		
		RegisDAO regisDAO=	new RegisDAO();
		   String sts = regisDAO.login(email, pass);
		   if(sts.equalsIgnoreCase(email))
		   {
			  HttpSession s = request.getSession();
			  s.setAttribute("email", email);
			  request.getRequestDispatcher("WelcomeServlet").forward(request, response);  
				
		   }
		   else
		   {
			   out.println("Wrong user id and pass");
			   request.getRequestDispatcher("login.html").include(request, response);  
		   }
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
