package DouDou;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartAdd
 */
@WebServlet("/CartAdd")
public class CartAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAdd() {
        super();
        // TODO Auto-generated constructor stub
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
		try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String email=(String) request.getSession().getAttribute("email");
		String movieName=request.getParameter("movieName");
		try {
			PreparedStatement ps=con.prepareStatement("update cart set num=num+1 where email=? and movieName=?;");
			ps.setString(1,email);
			ps.setString(2,movieName);
			int i=ps.executeUpdate();
			response.sendRedirect("MyCart");
			System.out.println("购物车电影数量加"+i);
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
