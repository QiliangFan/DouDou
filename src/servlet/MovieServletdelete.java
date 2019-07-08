package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MovieService;
import serviceimp.MovieServiceImp;
import vo.Movie;

/**
 * Servlet implementation class MovieServletdelete
 */
@WebServlet("/MovieServletdelete")
public class MovieServletdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServletdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieName");
		System.out.println(movieName);
		if(movieName!=null) {
			MovieService ms=new MovieServiceImp();
			Movie movie=new Movie();
			movie.setMovieName(movieName);
			System.out.println(movie.getMovieName());
			int a=ms.delete(movie);
			//System.out.println(a);
			response.sendRedirect("showmovie.jsp");
//			if(a>0) {
//				RequestDispatcher rd=request.getRequestDispatcher("showmovie.jsp");
//				rd.forward(request, response);
//			}
//			else {
//				RequestDispatcher rd=request.getRequestDispatcher("showmovie.jsp");
//				rd.forward(request, response);
//			}
//		}
//		else {
//			RequestDispatcher rd=request.getRequestDispatcher("showmovie.jsp");
//			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
