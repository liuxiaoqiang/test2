package Ynzc.YnzcAms.Util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class RunSQLGetListByJDBC {
	
	private Connection con;
	private String url="jdbc:mysql://localhost:3306/ynzcams";
	private String username="rabbit";
	private String password="rabbit";
	
	public Connection getConnection() throws SQLException{
		return con = (Connection) DriverManager.getConnection(url, username, password);
	}
	
}
