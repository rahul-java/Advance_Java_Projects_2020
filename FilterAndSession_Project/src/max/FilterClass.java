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
@WebFilter("/fs")
public class FilterClass implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		PrintWriter out = res.getWriter();
		int amount =Integer.parseInt(req.getParameter("amount"));
		out.println("before ");
		if(amount>=10)
		{
			chain.doFilter(req, res);
		}
		else
		{
			out.println("Invalid Amount in Card PlZ  "+amount);
		}
		out.println("after");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
