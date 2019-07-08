package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PosterService;
import serviceimp.PosterServiceImp;
import vo.Poster;

/**
 * Servlet implementation class PosterServletdelete
 */
@WebServlet("/PosterServletdelete")
public class PosterServletdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PosterServletdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieName");
		//System.out.println(movieName);
		if(movieName!=null) {
			PosterService ms=new PosterServiceImp();
			Poster poster=new Poster();
			poster.setMovieName(movieName);
			//System.out.println(poster.getMovieName());
			int a=ms.delete(poster);
			//System.out.println(a);
			response.sendRedirect("showposter.jsp");
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
