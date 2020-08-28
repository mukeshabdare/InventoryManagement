package com.inventory.repository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

import javax.sql.DataSource;

import org.h2.jdbcx.JdbcConnectionPool;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;


public class DatabaseConnector {

	
	public static Jdbi getDBI() {

		DataSource ds = JdbcConnectionPool.create("jdbc:h2:mem:PUBLIC;DB_CLOSE_DELAY=-1"
				+ ";DATABASE_TO_UPPER=false", "sa","");
		Jdbi jdbi = Jdbi.create(ds);
		return jdbi;
	}

	private File getFileFromResources(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("products.sql file is not found!");
		} else {
			return new File(resource.getFile());
		}

	}

	public static void main(String[] args) throws IOException {
		Jdbi jdbi = getDBI();
//		jdbi.useHandle(handle -> {
//		    handle.execute("create table contacts (id int primary key, name varchar(100))");
//		    handle.execute("insert into contacts (id, name) values (?, ?)", 1, "Alice");
//		    handle.execute("insert into contacts (id, name) values (?, ?)", 2, "Bob");
//		});
//		
//		Handle handle = jdbi.open();
//		String name = handle.createQuery("select name from contacts where id = ?")
//                .bind(0, 2)
//                .mapTo(String.class).findOnly();
//		System.out.println(name);
		setupDatabase(jdbi);

//		List<Product> products = handle.createQuery("select * from products").map(new ProductMapper()).list();
//		for (Product s : products) {
//			System.out.println(s.getDescription());
//		}
//		List<Product> name = handle.attach(InventoryRepository.class).getAllProducts();
//		System.out.println(name.size());
		
		JDBIProductDao dao = new JDBIProductDao();
		System.out.println(dao.getAllProducts().size());
		System.out.println(dao.getProductsByCategory("Computers").size());
	}

	public static void setupDatabase(Jdbi jdbi) throws IOException {
		DatabaseConnector dc = new DatabaseConnector();

		File file = dc.getFileFromResources("products.sql");

		String content = new String(Files.readAllBytes(file.toPath()));
		// System.out.println(content);

		Handle handle = jdbi.open();
		handle.createUpdate(content).execute();
		handle.close();
		return;
	}
}
