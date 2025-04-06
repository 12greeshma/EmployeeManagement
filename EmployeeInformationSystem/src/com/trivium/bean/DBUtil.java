package com.trivium.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	
	static Connection connection = null;
	static Statement statement = null;
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/triviumdb", "root", "12345");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return connection;
	}

}
