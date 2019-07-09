package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class toMovieinfo
 */
@WebServlet("/toMovieinfo")
public class toMovieinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    String[] MovieInfo=null;
    /*
     * 0 movieName
     * 1 picturename
     * 2 time
     * 3 country
     * 4 moviekind
     * 5 director
     * 6 screenwriter
     * 7 grade
     * 8. numOfPeople
     * 9. price
     */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toMovieinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		con=DouDou.sqlconnect.con;
	}

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
		MovieInfo=null;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String movieName=request.getParameter("lookmovieNameFromjs");
		System.out.println("debug-toMovieinfo:"+movieName);
		if(movieName!=null&&movieName!="")
		try {
			
			PreparedStatement ps=con.prepareStatement("select movie.movieName,image_address,time,country,movie.movieKind,director,screenwriter,grade,numOfPeople,actor\n" + 
					"from movie,Poster\n" + 
					"where movie.movieName=Poster.movieName and movie.movieName=?;");
			ps.setString(1, movieName);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MovieInfo=new String[] {
						rs.getString(1),  //0 movieName
						rs.getString(2),  //1 imageAddress
						rs.getString(3),  //2 time
						rs.getString(4),  //3 country
						rs.getString(5),  //4 moviekind
						rs.getString(6),  //5 director	
						rs.getString(7),    //6 screenwriter
						String.valueOf(rs.getDouble(8)),  //7 grade
						String.valueOf(rs.getDouble(9)),   // 8 numOfPeople 
						rs.getString(10),  //9 actor
				};
			}
			if(MovieInfo==null) {
				PrintWriter out=response.getWriter();
				out.println("<script>history.back(-1);</script>");
			}else {
			request.getSession().setAttribute("toMovieinfo", MovieInfo);
			System.out.println("toMovieinfo<-movie\\Poster=>get success!");
			System.out.println("toMovieifo.java->MovieInfo.jsp");
			response.sendRedirect("MovieInfo.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("movierank.jsp");
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
