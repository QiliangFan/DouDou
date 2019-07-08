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
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
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
		response.setContentType("utf-8");
		String email=request.getParameter("email");
		String movieName=request.getParameter("movieName");
		try {
			PreparedStatement ps=con.prepareStatement("select * from cart where email=? and movieName=?");
			ps.setString(1, email);
			ps.setString(2, movieName);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println(email+"had bought "+movieName);
				ps=con.prepareStatement("update cart set num=num+1 where email=? and movieName=?;");
				ps.setString(1, email);
				ps.setString(2, movieName);
				int i=ps.executeUpdate();
				ps.close();
				System.out.println("addToCart chage:"+i+"rows");
			}else {
				System.out.println(email+"had not bought "+movieName);
				PreparedStatement ps2=con.prepareStatement("insert into cart\n" + 
						"(select user.email,movie.movieName,1,movie.price,image_address\n" + 
						"from movie,Poster,user\n" + 
						" where movie.movieName=Poster.movieName and movie.movieName=? and user.email=?);");
				ps2.setString(1, movieName);
				ps2.setString(2, email);
				int i=ps2.executeUpdate();
				System.out.println("addToCart insert:"+i+"rows");
				ps2.close();
				
			}
			ps.close();
			response.sendRedirect("main.jsp?s=success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
