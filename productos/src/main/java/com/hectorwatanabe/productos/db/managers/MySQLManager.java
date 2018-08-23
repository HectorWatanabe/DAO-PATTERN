package com.hectorwatanabe.productos.db.managers;

import com.hectorwatanabe.productos.db.DAOManager;
import com.hectorwatanabe.productos.db.daos.ProductDAO;
import com.hectorwatanabe.productos.db.mysql.MySQLSingleton;

public class MySQLManager implements DAOManager{
	
	private MySQLSingleton mySQLSingleton = MySQLSingleton.getMySQLSingleton();
	
	@Override
	public ProductDAO getProductDAO() {
		return mySQLSingleton.getProductDAO();
	}
	
	@Override
	public void closeConnection() {
		mySQLSingleton.closeConnection();
	}

}
