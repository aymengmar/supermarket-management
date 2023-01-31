package application.Contruler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	private static String url="jdbc:mysql://localhost:3306/marketdb";
	private static String login="root";
	private static String pwd="";
	 private static Connection conn=null;

	
	
	
	
	private  ConnectionDB() {
		super();
		
	}





	public static  Connection openConnection() throws SQLException {
		
		
		if (conn==null) {
			conn= DriverManager.getConnection(url, login, pwd);

			
			
		}
		return conn;
		
	}
	 
	
	public static void closeConnection() {
		
		if (conn!=null) {
			conn=null;
			
		}
	}
	
	
}
