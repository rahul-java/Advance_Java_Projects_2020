package max;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/rahul")
public class MobileFilter implements Filter {

   
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String m = request.getParameter("mobile");
		
		if(m.length()==10)
		{
			String email = request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
		
			try {
				Connection con = UserConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(" select * from userlogin where email=?");
				ps.setString(1, email);
				//ps.setInt(2, 0);
				ResultSet rs = ps.executeQuery();
				String e1 = null;
				String m1 = null;
				while(rs.next())
				{
					e1 = rs.getString(1);
				    m1 = rs.getString(3);
				}
				
				if(email.equalsIgnoreCase(e1)&&mobile.equalsIgnoreCase(m1))
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
			}
		}
		else
		{
			out.println("Invalid Mobile Number :");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
