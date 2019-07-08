package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Shujuku {
	public static Connection conn(){
	    //定义连接初始值
		Connection connection=null;	
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//建立连接
			String url = "jdbc:MySQL://106.14.142.29:3306/DouDou?&useSSL=false&serverTimezone=UTC"; //数据库名
            String username = "root";  //数据库用户名
            String password = "fanqiliang";  //数据库用户密码
		    connection= DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return connection;	
	}
}
