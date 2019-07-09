package DouDou;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.sql.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Verify
 */
@WebServlet(urlPatterns = { "/Verify" }, initParams = { @WebInitParam(name = "current_usr", value = "") })
public class Verify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config = null;
	Connection con = null;

	/**
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @see HttpServlet#HttpServlet()
	 */
	public Verify() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql://106.14.142.29:3306/DouDou?useSSL=true", "javaweb",
//				"fanqiliang");

	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		config = null;
		con = null;
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		request.getSession();
		if (request.getParameter("signup") != null) {
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			try {

				java.sql.PreparedStatement ps = con.prepareStatement("select * from user where email=?;");
				String email = request.getParameter("email");
				String pwd1 = request.getParameter("pwd1");
				String pwd2 = request.getParameter("pwd2");
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					if (rs.getString(1).equals(email)) {
						out.println("<html>");
						out.println( "<head>");
						out.println("<title>您注册的邮箱已存在请重新注册</title>");
						out.println("</head>");
						out.println("<body>");
						out.println("<p style='font-size:20px;'>您注册的邮箱已存在请重新注册<br>3秒后返回到上一页...</p>");
						out.println("<script>\n" + 
								"        window.onload = timeout;\n" + 
								"        function timeout() {\n" + 
								"            setTimeout(redirect, 3000);\n" + 
								"        }\n" + 
								"        function redirect() {\n" + 
								"            window.history.go(-1);\n" + 
								"            location.reload();\n" + 
								"window.location.reload();\n"+
								"        }\n" + 
								"    </script>");
						out.println("</body>");
						return;
					}
				}
				rs.close();
				/*
				//to complete 邮箱验证功能！！！！
				 */
				PreparedStatement ps2=con.prepareStatement("insert into user values(?,?,'0')");
				ps2.setString(1,email);
				ps2.setString(2,md5(pwd1));
				ps2.executeUpdate();   //注册成功!
				request.getSession().setAttribute("email", email);
				request.getSession().setAttribute("authority","0");
				response.sendRedirect("main.jsp");
				out.flush();
				out.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect("main.jsp");
			}
		} else if (request.getParameter("login") != null) {//登陆验证
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out=response.getWriter();
			String email=request.getParameter("email");
			String pwd=request.getParameter("pwd");
			try {
				PreparedStatement ps=con.prepareStatement("select * from user where email=?;");
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				if(!rs.next()) {   //数据库中无此用户
					out.println("?");
					out.println("<head></head>\n" + 
							"<body>\n" + 
							"    <script>\n" + 
							"        alert(\"用户不存在！\");\n" + 
							"        window.history.go(-1);   \n" + 
							"        window.location.reload(); \n" + 
							"    </script>\n" + 
							"</body>");
				}else { //数据库中已存在用户，验证密码的正确性
					String rightpwd=rs.getString("pwd");
					String authority=rs.getString("authority");
					if(rightpwd.equals(md5(pwd))) {   //密码正确
						request.getSession().setAttribute("email", email);
						request.getSession().setAttribute("authority", authority);
						if(authority.equals("1"))response.sendRedirect("managerfind.jsp");
						else response.sendRedirect("main.jsp");
					}else {//密码错误
						out.println("<head></head>\n" + 
								"<body>\n" + 
								"    <script>\n" + 
								"        alert(\"密码错误！\");\n" + 
								"        window.history.go(-1);\n" + 
								"    </script>\n" + 
								"</body>");
					}
				}
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					DouDou.sqlconnect.init();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				response.sendRedirect("main.jsp");
			}
			
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String convertByteToString(byte[] bytes) {
		String result="";
		for(int i=0;i<bytes.length;i++) {
			int temp=bytes[i]&0xff;
			String tempHex=Integer.toHexString(temp);
			if(tempHex.length()<2) {
				result+="0"+tempHex;
			}else {
				result+=tempHex;
			}
		}
		return result;
	}
	public static String md5(String pwd) {
		String temp="";
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			byte[] encode=md5.digest(pwd.getBytes());
			temp=convertByteToString(encode);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}

}
