package max.update;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisDAO;
import max.reg.RegisDTO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		 String email = request.getParameter("email");
		 
		 List<RegisDTO> l = RegisDAO.getToUpdate(email);
		 
		 out.println("<html><body>");
		 out.println("<div id='updateHead1' align='center' style='background-color:skyblue'><h3>Update Details</h3></div>");
		 out.println("<form action='UpdateSuccessServlet' method='get'>");
		 for(RegisDTO p:l) {
		 out.println("<table border='5' bgcolor='skyblue' align='center'>");
		 out.println("<tr><th>Name :</th><td><input type='text' id='name' name='name' value='"+p.getName()+"'></td></tr>");
		 out.println("<tr><th>User Id :</th><td><input type='text' id='uid' name='uid' value='"+p.getUid()+"'></td></tr>");
		 out.println("<tr><th>Email :</th><td><input type='text' id='email' name='email' value='"+p.getEmail()+"' readonly='readonly'></td></tr>");
		 out.println("<tr><th>Phone :</th><td><input type='text' id='phone' name='phone' value='"+p.getPhone()+"'></td></tr>");
		 out.println("<tr><th>Password :</th><td><input type='text' id='pass' name='pass' value='"+p.getPass()+"'></td></tr>");
		 
		 out.println("</table>");
		 }
		 out.println("<div id='buttons'><table align='center'style='width:100%'><tr><td align='center'><input type='submit' value='Update'></input></td><td align='center'><a href='WelcomeServlet?email="+email+"'><h3> Home</h3></a></td>");
		 out.println("</form>");
		 out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
