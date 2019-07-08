package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class search extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=null;
    /**
     * @throws ClassNotFoundException 
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public search() throws ClassNotFoundException, SQLException {
    	
        super();
        
        
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			DouDou.sqlconnect.init();
			Class.forName("DouDou.sqlconnect");
			con=DouDou.sqlconnect.con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			this.con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("start to search!");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");   //注意编码问题！！！
		PrintWriter out=response.getWriter();
		String movieName=request.getParameter("searchcontent");
		if(movieName==null||movieName.length()==0) {
			request.getSession().setAttribute("movieNum","0");
		}else {
			try {
				PreparedStatement ps=con.prepareStatement("select * from Poster where movieName like ?;");
				int _count=0;
				ps.setString(1,"%"+movieName+"%");
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					String imagename=rs.getString("image_address");
					String moviename=rs.getString("movieName");
					_count++;
					request.getSession().setAttribute("movie"+_count, moviename);
					request.getSession().setAttribute("image"+_count, imagename);
				}
				rs.close();
				request.getSession().setAttribute("movieNum", String.valueOf(_count));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("SearchResult.jsp");
		out.close();
	}

}
