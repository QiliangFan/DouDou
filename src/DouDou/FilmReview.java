package DouDou;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FilmReview
 */

public class FilmReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection  con=null;
	List<String[] > Myfilmreview=new ArrayList<String[]>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmReview() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("DouDou.sqlconnect");
			con=DouDou.sqlconnect.con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
//			
//获取影评数据，并存储进入列表中
//			
			PreparedStatement ps=con.prepareStatement("select * from filmreview;");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String[] temp=new String[] {
						rs.getString("movieName"),  //0
						rs.getString("author"),//1
						rs.getString("review"),//2
						rs.getString("imageName"),//3
						rs.getString("readnum"),//4
						rs.getString("time")//5
				};
				Myfilmreview.add(temp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void destroy() {
		con=null;
		Myfilmreview=null;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		session.setAttribute("filmreviewlist", Myfilmreview);
		response.sendRedirect("../index.jsp?s=true");
	}

}
