package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MovieService;
import serviceimp.MovieServiceImp;
import vo.Movie;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieName");
		String time=request.getParameter("time");
		String country=request.getParameter("country");
		String screenwriter=request.getParameter("screenwriter");
		String moviekind=request.getParameter("moviekind");
		String grade=request.getParameter("grade");
		String numOfPeople=request.getParameter("numOfPeople");
		String price=request.getParameter("price");
		String actor=request.getParameter("actor");
		String director=request.getParameter("director");
		System.out.println(movieName);
		if(!movieName.equals("")) {
			MovieService ms=new MovieServiceImp();
			Movie movie=new Movie();
			movie.setMovieName(movieName);
			movie.setActor(actor);
			movie.setCountry(country);
			movie.setDirector(director);
			movie.setGrade(Double.valueOf(grade.toString()));
			movie.setMoviekind(moviekind);
			movie.setNumOfPeople(Double.valueOf(numOfPeople.toString()));
			movie.setTime(time);
			movie.setPrice(Integer.valueOf(price.toString()));
			movie.setScreenwriter(screenwriter);
			int a=ms.addMovie(movie);
			if(a>0) {
				RequestDispatcher rd=request.getRequestDispatcher("showmovie.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("addmovie.jsp");
				rd.forward(request, response);
			}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("addmovie.jsp");
			rd.forward(request, response);
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
