package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetAllFilmReview
 */
@WebServlet("/GetAllFilmReview")
public class GetAllFilmReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
	List<String[]> allfilmreivew=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllFilmReview() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		con=DouDou.sqlconnect.con;
		allfilmreivew=new ArrayList<String[]>();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		con=null;
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		allfilmreivew.clear();
		try {
			PreparedStatement ps = con.prepareStatement("select * from filmreview;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				allfilmreivew.add(
						new String[]{
							rs.getString(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6)
						});
			}
			request.getSession().setAttribute("allfilmreview",allfilmreivew);//***********
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("allfilmreview.jsp?s=GetAllFilmReview");
			PrintWriter out=response.getWriter();
			out.println("<script>\n" + 
					"    window.location.href=\"MyOwnPage.jsp?s=GetAllFilmReview\"\n" + 
					"</script>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
	

}
