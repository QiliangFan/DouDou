package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.FilmReviewService;
import serviceimp.FilmReviewServiceImp;
import vo.FilmReview;

/**
 * Servlet implementation class FilmReviewServletdelete
 */
@WebServlet("/FilmReviewServletdelete")
public class FilmReviewServletdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmReviewServletdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieName");
		String author=request.getParameter("author");
		String time=request.getParameter("time");
//		System.out.println(movieName);
//		System.out.println(author);
//		System.out.println(time);
		if(movieName!=null&&author!=null&&time!=null) {
			FilmReviewService ms=new FilmReviewServiceImp();
			FilmReview fr=new FilmReview();
			fr.setAuthor(author);
			fr.setTime(time);
			fr.setMovieName(movieName);
			//System.out.println(poster.getMovieName());
			int a=ms.delete(fr);
			//System.out.println(a);
			response.sendRedirect("showfilmreview.jsp");
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
