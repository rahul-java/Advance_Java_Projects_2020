package max.updte;

import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisBean;
import max.reg.RegisDAO;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out = response.getWriter();   
    	String email = request.getParameter("email");
    	RegisBean b = RegisDAO.getRecordsByEmail(email);
    	
    	out.println("<html><body>");
    	out.println("<form action ='RegisServlet'>");
        out.println("<table border='3' bgcolor='yellow'align='center' >");
        out.println("<tr><td >   User ID  </td><td><input type='text' name='uid' value='"+b.getUid()+"'   </td> </tr>");
        out.println("<tr><td >   Name  </td><td><input type='text' name='name' value='"+b.getName()+"'   </td> </tr>");
        out.println("<tr><td >   Email  </td><td><input type='text' name='email' value='"+b.getEmail()+"'   </td> </tr>");
        out.println("<tr><td >   Phone  </td><td><input type='text' name='phone' value='"+b.getPhone()+"'   </td> </tr>");
        out.println("<tr><td><input type='submit' value='update'   </td> </tr>");
        out.println("</table></form></body></html>");

   		}
   	
	}
