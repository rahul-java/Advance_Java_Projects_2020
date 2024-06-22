package max;

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      static Connection con=null; 
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String mobile= request.getParameter("mobile");
		String pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(email==""||name==""||mobile==""||pwd=="")
		{
			out.println("Please Enter Valid details all fields are mandatory....");
			out.println("<a href='register.html'>Register Again...</a>");
		}
		else
		{
		if(!User.getUser(email))
		{
			
					if(User.insertUser(email, name, mobile, pwd)==1)
					{
						out.println("Registered Successfully..");
						out.println("<a href='index.html'>Login Now</a>");
						
					}
					else
					{
						out.println("Errorrrr");
						out.println("<a href='register.html'>Register Here</a>");
					}
					
					
		}
		else
		{
			out.println("User alredy exist in the database");
			out.println("<a href='register.html'>Register Again...</a>");
		}
		}

	}
			
}
