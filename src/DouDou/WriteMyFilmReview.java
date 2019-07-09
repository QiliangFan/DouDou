package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteMyFilmReview
 */
@WebServlet("/WriteMyFilmReview")
public class WriteMyFilmReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteMyFilmReview() {
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
		String email=(String)request.getSession().getAttribute("email");
		
		String text=null,movieName=null,imageName=null;
		try {
		text=request.getParameter("writemyfilmreivew");
		movieName=(((String[]) request.getSession().getAttribute("toMovieinfo"))[0]);
		imageName=(((String[]) request.getSession().getAttribute("toMovieinfo"))[1]);
		}catch (Exception e) {
			PrintWriter out=response.getWriter();
			out.println("<script>history.go(-1);</script>");
		}
		if(text==null||movieName==null) {
			PrintWriter out=response.getWriter();
			out.println("<script>history.go(-1);</script>");
		}
		
		System.out.println("WriteFilmReview=> "+movieName+"add review:"+text+" by "+email);
		try {
			SimpleDateFormat spd=new SimpleDateFormat("yyyy-MM-dd");
			PreparedStatement ps=con.prepareStatement("select * from filmreview where review=? and author=? and time=?;");
			ps.setString(1, text);
			ps.setString(2, email);
			ps.setString(3, spd.format(new java.util.Date()));
			ResultSet rs=ps.executeQuery();
			System.out.println(text+email+spd.format(new java.util.Date()));
			if(rs.next()) {
				
				response.sendRedirect("MovieInfo.jsp?s=fail");
				return;
			}
			ps=con.prepareStatement("insert into filmreview values(?,?,?,?,?,?);");
			ps.setString(1,text);
			ps.setString(2, imageName);
			ps.setInt(3, 0);
			ps.setString(4, email);
			ps.setString(5,movieName);
			
			ps.setString(6, spd.format(new java.util.Date()));
			ps.executeUpdate();
			System.out.println("WriteMyFilmReview.java success!");
			response.sendRedirect("MovieInfo.jsp?s=success");
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
