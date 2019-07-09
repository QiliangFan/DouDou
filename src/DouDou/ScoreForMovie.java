package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class ScoreForMovie
 */
@WebServlet("/ScoreForMovie")
public class ScoreForMovie extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection  con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreForMovie() {
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
		String score=request.getParameter("scoreinput");
		String email=(String)request.getSession().getAttribute("email");
		if(email==null||email.equals("")) {
			response.sendRedirect("movierank.jsp");
		}
		System.out.println("ScoreForMovie get score:"+score);
		try {
			PreparedStatement ps=con.prepareStatement("update movie set grade=grade+? ,numOfPeople=numOfPeople+1 where movieName=?");
			String movieName=((String[])(request.getSession().getAttribute("toMovieinfo")))[0];
			System.out.println("ScoreForMovie.java start add score "+score+" for "+movieName);
			ps.setString(1,score);
			ps.setString(2, movieName);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("ScoreForMovie.java success!");
			}else {
				System.out.println("ScoreForMovie.java failed!");
			}
			response.sendRedirect("MovieInfo.jsp?score=true");
		} catch (SQLException e) {
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
