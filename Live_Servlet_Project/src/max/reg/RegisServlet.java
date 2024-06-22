package max.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisServlet")
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uid = request.getParameter("uid");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		RegisBean regisBean=new	RegisBean();
		regisBean.setName(name);
		regisBean.setEmail(email);
		regisBean.setPhone(phone);
		regisBean.setUid(uid);
		
		RegisBO regisBO=	new RegisBO ();
		    if(regisBO.getRegisDetails(regisBean))
		    {  out.println("Successs full");
		    	
		    		    
		   }
		    else
		    {
		    	out.println("Errrooor DB ");
		    }
		    request.getRequestDispatcher("regis.html").include(request, response);	
			
	}

	

}
