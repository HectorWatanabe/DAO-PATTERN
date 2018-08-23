package com.hectorwatanabe.productos.db;

import java.util.List;

public interface DAO<Model, Id> {
	
	public void insert(Model m);

	public void update(Model m);

	public void delete(Id id);

	public List<Model> getall();

	public Model getone(Id id);
	
}
