package max;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class ListnerClass_Rahul implements ServletContextListener, HttpSessionListener, ServletRequestListener {

    
	
    public void sessionCreated(HttpSessionEvent se)  
    { 
        System.out.println("Session Created .....");
    }

	
    public void requestDestroyed(ServletRequestEvent sre)
    { 
        System.out.println("Request Destroyed....");
    }

	
    public void requestInitialized(ServletRequestEvent sre)
    { 
         System.out.println("Request Initializes.....");
    }

	
    public void sessionDestroyed(HttpSessionEvent se) 
    { 
        System.out.println("Session Destroyed......");
    }

	
    public void contextDestroyed(ServletContextEvent sce) 
    { 
     System.out.println("Context Destroyed.....");
    }

	
    public void contextInitialized(ServletContextEvent sce) 
    { 
         System.out.println("Context Initializes....");
    }
	
}
