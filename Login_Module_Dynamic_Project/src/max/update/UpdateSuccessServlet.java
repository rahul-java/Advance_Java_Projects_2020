package max.update;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import max.reg.RegisDAO;
import max.reg.RegisDTO;


@WebServlet("/UpdateSuccessServlet")
public class UpdateSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		RegisDTO regisDTO=new RegisDTO();
		regisDTO.setEmail(request.getParameter("email"));
		regisDTO.setName(request.getParameter("name"));
		regisDTO.setUid(request.getParameter("uid"));
		regisDTO.setPass(request.getParameter("pass"));
		regisDTO.setPhone(request.getParameter("phone"));
		
		if(RegisDAO.updateDetails(regisDTO))
		{
			out.println("Updated Successfully....");
		 }
		else
		{
			out.println("Something Went Wrong try again....");
		}
		request.getRequestDispatcher("WelcomeServlet").include(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
