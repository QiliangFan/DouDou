package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Shujuku {
	public static Connection conn(){
	    //�������ӳ�ʼֵ
		Connection connection=null;	
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			String url = "jdbc:MySQL://106.14.142.29:3306/DouDou?&useSSL=false&serverTimezone=UTC"; //���ݿ���
            String username = "root";  //���ݿ��û���
            String password = "fanqiliang";  //���ݿ��û�����
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
