package MyListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class SessionLifeStyle
 *
 */
@WebListener
public class SessionLifeStyle implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SessionLifeStyle() {
        // TODO Auto-generated constructor stub
    	
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	
         
    }
	
}
