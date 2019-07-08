package DouDou;

import java.sql.*;

public class sqlconnect {
	static public Connection con=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public sqlconnect() {
		// TODO Auto-generated constructor stub
	}
	public static void init() throws SQLException {
		
		if(con.isClosed()&&!con.isValid(20)) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://106.14.142.29/DouDou?useSSL=true","javaweb","fanqiliang");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

}
