package com.hectorwatanabe.productos.db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	
	private static MySQLConnection mySQLConnection;
	private Connection conn;
	
	private MySQLConnection() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/products_db", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public static synchronized MySQLConnection getMySQLConnection() {
		if(mySQLConnection == null) {
			mySQLConnection = new MySQLConnection();
		}
		return mySQLConnection;
	}

	public Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
