package max.reg;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
	    ServletConfig config = getServletConfig();
	    ServletContext ctx = getServletContext();
	 
		String uid = request.getParameter("uid");
	    ctx.setAttribute("a", uid);
	    
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
		
		   int i = regisBO.getRegisDetails(regisBean);
		    if(i==1)
		    {
		    	
		    	out.println("Inserted Records Successfully in DB ");
request.getRequestDispatcher("login.html").include(request, response);	
				
		    }
		    if(i==2)
		    {
		    	out.println("Updated Records Successfully in DB ");
request.getRequestDispatcher("WelcomeServlet").include(request, response);	
				
		    }
		    if(i==0)
		    {
		    	out.println("Errrorrr Something went wrong DB ");
		    	request.getRequestDispatcher("regis.html").include(request, response);	
	
		    }
		    	
	}

	

}
