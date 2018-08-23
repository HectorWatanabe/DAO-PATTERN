package com.hectorwatanabe.productos.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hectorwatanabe.productos.db.daos.ProductDAO;
import com.hectorwatanabe.productos.models.Product;
import com.mysql.jdbc.Statement;

public class MySQLProductDAO implements ProductDAO {

	private final String INSERT = "INSERT INTO products(name,description,stock,price) VALUES(?,?,?,?)";
	private final String UPDATE = "UPDATE products SET name = ?, description = ?, stock = ?, price = ? WHERE id = ?";
	private final String DELETE = "DELETE FROM products WHERE id = ?";
	private final String GETALL = "SELECT id,name, description, stock, price FROM products";
	private final String GETONE = GETALL + " WHERE id = ?";

	private Connection conn;

	public MySQLProductDAO(Connection conn) {
		this.conn = conn;
	}

	public void insert(Product m) {
		try {
			PreparedStatement stat = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stat.setString(1, m.getName());
			stat.setString(2, m.getDescription());
			stat.setInt(3, m.getStock());
			stat.setFloat(4, m.getPrice());
			stat.executeUpdate();
			ResultSet rs = stat.getGeneratedKeys();
			if(rs.next()) {
				m.setId(rs.getInt(1));
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Product m) {
		try {
			PreparedStatement stat = conn.prepareStatement(UPDATE);
			stat.setString(1, m.getName());
			stat.setString(2, m.getDescription());
			stat.setInt(3, m.getStock());
			stat.setFloat(4, m.getPrice());
			stat.setInt(5, m.getId());
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer id) {
		try {
			PreparedStatement stat = conn.prepareStatement(DELETE);
			stat.setInt(1, id);
			stat.executeUpdate();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Product> getall() {

		List<Product> products = new ArrayList<Product>();

		try {
			PreparedStatement stat = conn.prepareStatement(GETALL);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setStock(rs.getInt("stock"));
				product.setPrice(rs.getFloat("price"));
				products.add(product);
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	public Product getone(Integer id) {

		Product product = new Product();

		try {
			PreparedStatement stat = conn.prepareStatement(GETONE);
			stat.setInt(1, id);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setStock(rs.getInt("stock"));
				product.setPrice(rs.getFloat("price"));
			}
			rs.close();
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

}
