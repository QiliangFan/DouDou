package MyListener;
import DouDou.*;


import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
/**
 * Application Lifecycle Listener implementation class HistoryLook
 *
 */
@WebListener
public class HistoryLook implements ServletRequestListener {
	Connection con=null;
    /**
     * Default constructor. 
     */
    public HistoryLook() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	con=null;
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    	try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
    	try {
			sre.getServletRequest().setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	String lookmovieNameFromjs=sre.getServletRequest().getParameter("lookmovieNameFromjs");
    	String email=sre.getServletRequest().getParameter("email");
    	
    	String movieName=sre.getServletRequest().getParameter("movieName");
    	String addtocart=sre.getServletRequest().getParameter("addtocart");
    	if(movieName!=null&&addtocart!=null&&email!=null&&!movieName.equals("")&&!addtocart.equals("")&&!email.equals("")) {
    		try {
				PreparedStatement ps=con.prepareStatement("insert into history values(?,?,?,'购买')");
				ps.setString(1, email);
				SimpleDateFormat spd=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
				ps.setString(2, spd.format(new Date()));
				ps.setString(3, movieName);
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	List<String[]> filmreivewForAFilmList=new ArrayList<String[]>() ;
    	if(lookmovieNameFromjs!=null&&!lookmovieNameFromjs.equals("")) {
    		PreparedStatement ps_filmreview;
			try {
				ps_filmreview = con.prepareStatement("select * from filmreview where movieName=? ;");
				ps_filmreview.setString(1, lookmovieNameFromjs);
				ResultSet rs=ps_filmreview.executeQuery();
				while(rs.next()) {
				System.out.println("filmreivewForAFilmList generate successfully!");
				filmreivewForAFilmList.add(new String[]{
					rs.getString(1),//0 review
					rs.getString(2),//1 imageName
					rs.getString(3),//2 readNum
					rs.getString(4),//3 author
					rs.getString(5), //4 movieName
					rs.getString(6)  //5 time
				});
				}
				sre.getServletRequest().getServletContext().setAttribute("filmreivewForAFilmList", filmreivewForAFilmList);
				/*!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!application数据!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    	if(lookmovieNameFromjs!=null&&!lookmovieNameFromjs.equals("")&&email!=null&&!email.equals("")) {
    		try {
				PreparedStatement ps=con.prepareStatement("insert into history values(?,?,?,?);");
				ps.setString(1,email);
				SimpleDateFormat spd=new SimpleDateFormat("yyyy-MM-DD HH:mm:ss");
				ps.setString(2, spd.format(new Date()));
				ps.setString(3,lookmovieNameFromjs);
				ps.setString(4, "浏览");
				int i=ps.executeUpdate();
				System.out.println("HistoryLock.java->history=>success:"+String.valueOf(i));
				

				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
