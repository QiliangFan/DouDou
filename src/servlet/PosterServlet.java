package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.PosterService;
import serviceimp.PosterServiceImp;
import vo.Poster;

/**
 * Servlet implementation class PosterServlet
 */
@WebServlet("/PosterServlet")
public class PosterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PosterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String movieName=request.getParameter("movieName");
		String picturename=request.getParameter("picturename");
		String image_address=request.getParameter("image_address");
		//System.out.println(movieName);
		if(!movieName.equals("")) {
			PosterService ms=new PosterServiceImp();
			Poster poster=new Poster();
			poster.setImage_address(image_address);
			poster.setMovieName(movieName);
			poster.setPicturename(picturename);
			int a=ms.addPoster(poster);
			if(a>0) {
				RequestDispatcher rd=request.getRequestDispatcher("showposter.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd=request.getRequestDispatcher("addposter.jsp");
				rd.forward(request, response);
			}
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("addposter.jsp");
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
