package com.inventory.repository;

import java.io.IOException;
import java.util.List;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class JDBIProductDao implements InventoryRepository {
	
	private Jdbi jdbi = DatabaseConnector.getDBI();
	private Handle handle = jdbi.open();
	
	@Override
	public List<Product> getAllProducts() {
		
		List<Product> products = handle.createQuery("select * from products")
				.map(new ProductMapper()).list();
		return products;
	}

	@Override
	public List<Product> getProductsByCategory(String category) {
		
		String query = "select * from products where category = :category";
		List<Product> products = handle.createQuery(query)
				.bind("category",category)
				.map(new ProductMapper()).list();
		return products;
	}

	@Override
	public List<Product> getProductsByCompany(String company) {
		String query = "select * from products where company = :company";
		List<Product> products = handle.createQuery(query)
				.bind("company",company)
				.map(new ProductMapper()).list();
		return products;
	}
	
	public String createTable() {
		try {
			DatabaseConnector.setupDatabase(jdbi);
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Failed";
	} 
	
}
