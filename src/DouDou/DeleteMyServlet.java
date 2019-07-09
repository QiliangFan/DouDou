package DouDou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteMyServlet
 */
@WebServlet("/DeleteMyServlet")
public class DeleteMyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMyServlet() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		con=DouDou.sqlconnect.con;
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
		
		// TODO Auto-generated method stub
		try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieNameFromTable");
		String emailName=(String) request.getSession().getAttribute("email");
		String text=request.getParameter("filmtext");
		try {
			PreparedStatement ps=con.prepareStatement("delete from filmreview where movieName=? and author=? and review=?;");
			ps.setString(1, movieName);
			ps.setString(2,emailName);
			ps.setString(3,text);
			System.out.println(movieName+emailName+text);
			int i=ps.executeUpdate();                           //****************************************************to be continued!
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("MyOwnPage.jsp");
			System.out.println("DeleteMyServlet删除"+i);
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
