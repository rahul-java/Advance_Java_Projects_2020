package max;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


import user.UserConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import user.UserConnection;



@WebFilter("/rahul")
public class LoginFilter implements Filter {

   
	public void destroy() {
	
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String mobile=request.getParameter("mobile");
		
	/*	Connection con = UserConnection.getConnection();
		try {
			
			PreparedStatement ps = con.prepareStatement("select email ,password from userlogin where email=? and cflag=?");
			ps.setString(1, email);
			ps.setInt(2, 0);
			ResultSet rs = ps.executeQuery();
			String e = rs.getString(1);
			String m = rs.getString(2);
			
			if(email.equalsIgnoreCase(e)&&mobile.equalsIgnoreCase(m))
			{
				chain.doFilter(request, response);
			}
			else
			{
				out.println("Sorry Email Id or Password you have entered is incorrect...");
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}*/
		if(mobile.equalsIgnoreCase("8299552516"))
		{
			chain.doFilter(request, response);
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
