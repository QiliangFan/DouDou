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
 * Servlet implementation class MovieServletupdate
 */
@WebServlet("/MovieServletupdate")
public class MovieServletupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServletupdate() {
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
		if(movieName!=null&&time!=null
				&&country!=null
				&&screenwriter!=null
				&&moviekind!=null
				&&grade!=null
				&&numOfPeople!=null
				&&price!=null
				&&actor!=null
				&&director!=null) {
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
			System.out.println(movie.getMovieName());
			int a=ms.update(movie);
			//System.out.println(a);
			response.sendRedirect("showmovie.jsp");
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
