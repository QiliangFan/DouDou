package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class GetMyFilmReview
 */
@WebServlet("/GetMyFilmReview")
public class GetMyFilmReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
    List<String[]> myfilmreivew=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyFilmReview() {
        super();
        // TODO Auto-generated constructor stub
        myfilmreivew=new ArrayList<String[]>();
    }
    
    public void init(ServletConfig config) {
    	con=DouDou.sqlconnect.con;
    }
    
    public void destory() {
    	con=null;
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	myfilmreivew.clear();
		try {
			System.out.println("???");
			PreparedStatement ps = con.prepareStatement("select * from filmreview where author=?;");
			ps.setString(1, (String)(request.getSession().getAttribute("email")));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				myfilmreivew.add(
						new String[]{
							rs.getString(1),  //0 review
							rs.getString(2),  //1 imageName
							rs.getString(3),   //2 readNum
							rs.getString(4),    //3 author
							rs.getString(5),   //4 movieName
							rs.getString(6)   //5time
						});
			}
			request.getSession().setAttribute("myfilmreview",myfilmreivew);//***********
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			response.sendRedirect("myfilmreview.jsp?s=GetMyFilmReview");		
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
