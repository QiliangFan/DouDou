package DouDou;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyCart
 */
@WebServlet("/MyCart")
public class MyCart extends HttpServlet {	 
	private static final long serialVersionUID = 1L;
    Connection con=null;  
    List<String[]> cartList=null;
		/**
     * @see HttpServlet#HttpServlet()
     */
    
    public void init(ServletConfig config) {
    	con=DouDou.sqlconnect.con;
    	cartList=new ArrayList<String[]>();
    }
    
    public void destory() {
    	con=null;
    }

    public MyCart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cartList.clear();
		request.setCharacterEncoding("utf-8");
		String email=(String) request.getSession().getAttribute("email");
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from cart where email=?;");
			ps.setString(1, email);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				cartList.add(new String[] {
						rs.getString(1),   //email
						rs.getString(2),   //movieName
						String.valueOf(rs.getInt(3)),  //num
						String.valueOf(rs.getInt(4)),    //price
						rs.getString(5)   //imageName
				});
			}
			request.getSession().setAttribute("mycart",cartList );
			response.sendRedirect("mycart.jsp?s=MyCart");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
