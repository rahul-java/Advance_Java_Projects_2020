package com.in.Uid.Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in.Uid.Bean.ChangePassword;
import com.in.Uid.Doa.ChangeuserpassDoa;

/**
 * Servlet implementation class ChangePasswordController
 */
@WebServlet("/pass")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         
		ChangePassword password=new ChangePassword();
		ChangePassword changepassword = password.setuserdetails(request);
		String changepass=changepassword.getUserpassword();
		String confirmpass=changepassword.getConf_password();
		
		if(changepass.equals(confirmpass))
				{		
		                  
			try {
				boolean success=false;
			success =ChangeuserpassDoa.changeuserdetails(changepassword);
				 if(success)
				 {
					 response.sendRedirect("Success.jsp");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		else {
			response.sendRedirect("cpwd.jsp");
		}
	

	}
	}

