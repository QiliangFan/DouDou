package MyListener;

import java.sql.SQLException;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.sun.corba.se.spi.servicecontext.ServiceContexts;

/**
 * Application Lifecycle Listener implementation class DBclose
 *
 */
@WebListener
public class DBclose implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public DBclose() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	try {
			DouDou.sqlconnect.init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	System.out.println("session created,sql init.");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session timeout!");
        try {
			if(!DouDou.sqlconnect.con.isClosed())
				DouDou.sqlconnect.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
