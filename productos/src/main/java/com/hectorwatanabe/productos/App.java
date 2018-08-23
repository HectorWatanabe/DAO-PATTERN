package com.hectorwatanabe.productos;

import java.util.ArrayList;
import java.util.List;

import com.hectorwatanabe.productos.db.DAOManager;
import com.hectorwatanabe.productos.db.managers.MySQLManager;
import com.hectorwatanabe.productos.models.Product;

public class App {
	public static void main(String[] args) {
		
		DAOManager daoManager = new MySQLManager();

		// --- Crear Producto ---
		/*
		 * Product product = new Product();
		 * 
		 * product.setName("Aceite Cocinero");
		 * product.setDescription("El aceite que los peruanos quieren");
		 * product.setStock(25); product.setPrice(7.50f);
		 * 
		 * daoManager.getProductDAO().insert(product);
		 * 
		 * System.out.println(product.getId());
		 */

		// --- Actualizar Producto ---
		/*
		 * Product product = new Product();
		 * 
		 * product.setId(1); product.setName("Leche Gloria Deslactosada");
		 * product.setDescription("La leche que todos los peruanos quieren");
		 * product.setStock(30); product.setPrice(5.00f);
		 * 
		 * daoManager.getProductDAO().update(product);
		 */

		// --- Eliminar Producto ---
		/* daoManager.getProductDAO().delete(2); */

		// --- Listar Productos ---

		List<Product> products = new ArrayList<>();

		products = daoManager.getProductDAO().getall();

		for (Product p : products) {
			System.out.println(p);
		}

		daoManager.closeConnection();

		// --- Obtener un Producto ---
		/*
		 * Product product = daoManager.getProductDAO().getone(1);
		 * 
		 * System.out.println(product.toString());
		 */
	}
}
