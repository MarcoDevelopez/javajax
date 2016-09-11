package com.marqo404.javajax.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection;
	
	private static String driver		= "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url		 		= "jdbc:sqlserver://localhost:1433;databaseName=JavAjax";
	private static String user 			= "sa";
	private static String password 	= "123456789";
	
	public ConnectionFactory() {
	}
	
	public static Connection open() throws ClassNotFoundException, SQLException {
		if (connection == null) {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		}
		return connection;
	}
	
	public static void close() throws SQLException {
		if (connection != null) connection.close();
		connection = null;
	}
	
}
