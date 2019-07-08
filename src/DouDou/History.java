package DouDou;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class History
 */
@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;  
    List<String[]> history=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		con=DouDou.sqlconnect.con;
		history=new ArrayList<String[]>();
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		history.clear();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String email=(String) request.getSession().getAttribute("email");
		try {
			PreparedStatement ps=con.prepareStatement("select * from history where email=? order by time;");
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
					history.add(new String[] {
							rs.getString(1),   //email
							rs.getString(2),    //time
							rs.getString(3),    //emailName
							rs.getString(4),    //type
					});
			}
			request.getSession().setAttribute("history", history);
			response.sendRedirect("history.jsp?s=History");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
