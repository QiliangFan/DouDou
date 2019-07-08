package DouDou;

import java.io.IOException;
import java.sql.Connection;
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
 * Servlet implementation class CartSub
 */
@WebServlet("/CartSub")
public class CartSub extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartSub() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String email=(String) request.getSession().getAttribute("email");
		String movieName=request.getParameter("movieName");
		System.out.println(movieName);
		try {
			PreparedStatement ps=con.prepareStatement("update cart set num=case\n" + 
					"when num<=0 then 0\n" + 
					"else num-1\n" + 
					"end\n" + 
					"where email=? and movieName=?;");
			ps.setString(1, email);
			ps.setString(2, movieName);
			int i=ps.executeUpdate();
			ps=con.prepareStatement("delete from cart where num=0;");
			ps.executeUpdate();
			if(i==1) System.out.print(email+"的"+movieName+"数量成功减一");
			response.sendRedirect("MyCart");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
