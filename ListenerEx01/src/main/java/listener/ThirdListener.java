package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ThirdListener
 *
 */
@WebListener
public class ThirdListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ThirdListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println( "ThirdListener contextDestroyed 호출");

    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println( "ThirdListener contextInitialized 호출");

    }
	
}
