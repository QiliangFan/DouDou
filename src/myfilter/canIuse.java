package myfilter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class canIuse
 */
@WebFilter("/canIuse")
public class canIuse implements Filter {
	Connection con=null;
    /**
     * Default constructor. 
     */
    public canIuse() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// p	ass the request along the filter chain
		chain.doFilter(request, response);
		HttpServletRequest myrequest=(HttpServletRequest)request;
		String email=(String) myrequest.getSession().getAttribute("email");
		PreparedStatement ps;
		String authority=null;
		try {
			ps = con.prepareStatement("select authority from user where email=?;");
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				authority=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(email==null||email.equals("")||authority==null||authority.equals("0")) {
			((HttpServletResponse)response).sendRedirect("main.jsp");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		con=DouDou.sqlconnect.con;
	}

}
