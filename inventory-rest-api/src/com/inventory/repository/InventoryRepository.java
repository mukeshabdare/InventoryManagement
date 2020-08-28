/**
 * 
 */
package com.inventory.repository;

import java.util.List;

public interface InventoryRepository {
	
	List<Product> getAllProducts();
	
	List<Product> getProductsByCategory(String category);

	List<Product> getProductsByCompany(String company);
}
