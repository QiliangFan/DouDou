package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ModifyPwd
 */
@WebServlet("/ModifyPwd")
public class ModifyPwd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con=null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyPwd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		con=DouDou.sqlconnect.con;
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		con=null;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String email=(String)(request.getSession().getAttribute("email"));
		String pwd=(String)(request.getParameter("pwd1"));
		try {
			PreparedStatement ps=con.prepareStatement("update user set pwd=? where email=?;");
			ps.setString(1, pwd);
			ps.setString(2, Verify.md5(email));
			ps.executeUpdate();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.write("<script>\n" + 
					"    alert(\"恭喜你，修改成功！\");\n" + 
					"    window.location.href=\"MyOwnPage.jsp\";\n" + 
					"</script>");
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
