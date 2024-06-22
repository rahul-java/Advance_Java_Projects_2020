package max;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ListnerClass implements ServletContextListener,ServletRequestListener,HttpSessionListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
	}

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("requestDestroyed");
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("requestInitialized");
	}

	@Override
	public void sessionCreated(HttpSessionEvent sc) {
		// TODO Auto-generated method stub
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sd) {
		// TODO Auto-generated method stub
		
		HttpSession d = sd.getSession();
		  String t = (String) d.getAttribute("am");
		  
		System.out.println("sessionDestroyed "+t);
	}

}
