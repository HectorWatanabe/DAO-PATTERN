package com.hectorwatanabe.productos.db.mysql;

import com.hectorwatanabe.productos.db.daos.ProductDAO;

public class MySQLSingleton {
	
	private static MySQLSingleton mySQLSingleton;
	private MySQLConnection mySQLConnection;
	private ProductDAO productDAO;
	
	private MySQLSingleton() {
		mySQLConnection = MySQLConnection.getMySQLConnection();
		productDAO = new MySQLProductDAO(mySQLConnection.getConnection());
	}
	
	public static MySQLSingleton getMySQLSingleton() {
		if(mySQLSingleton == null) {
			mySQLSingleton = new MySQLSingleton();
		}
		return mySQLSingleton;
	}
	
	public void closeConnection() {
		mySQLConnection.closeConnection();
	}
	
	public ProductDAO getProductDAO() {
		return productDAO;
	}
}
