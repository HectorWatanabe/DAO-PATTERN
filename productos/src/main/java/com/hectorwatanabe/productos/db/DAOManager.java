package com.hectorwatanabe.productos.db;

import com.hectorwatanabe.productos.db.daos.ProductDAO;

public interface DAOManager {
	public ProductDAO getProductDAO();
	public void closeConnection();
}
