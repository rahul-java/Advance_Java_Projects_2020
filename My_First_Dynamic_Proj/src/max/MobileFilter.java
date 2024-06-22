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
		String email = request.getParameter("email");
		String mobile=request.getParameter("mobile");
		if(mobile.length()==10)
		{
				if(User.checkUserEmailMobile(email,mobile))
				{
					chain.doFilter(request, response);
				}
				else
				{
					out.println("Sorry Email Id or Password you have entered is incorrect... or Register first");
					out.println("<a href='register.html'>Register Here</a>");
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
