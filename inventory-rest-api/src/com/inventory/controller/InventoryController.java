package com.inventory.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.inventory.repository.JDBIProductDao;
import com.inventory.repository.Product;

/**
 * @author abdare
 *
 */
@Path("services")
public class InventoryController {
	private JDBIProductDao dao = new JDBIProductDao();
	
	@GET @Path("/createDatabase")
	@Produces("text/plain")
	public Response createDatabase () {
		String status = dao.createTable();
		String result1 = "Database creation " + status;
		return Response.status(200).entity(result1).build();
	}
	
	@GET @Path("/getAllProducts")
	@Produces({ MediaType.APPLICATION_JSON})
	public List<Product> getAllProducts () {
		return dao.getAllProducts();
	}
	
	 @GET @Path("/getAllProductsByCategory/{category}")
	    @Produces({ MediaType.APPLICATION_JSON})
	    public List<Product> getAllProdctsByCategory(@PathParam("category") String category) {
	        return dao.getProductsByCategory(category);
	    }
	
	 @GET @Path("/getAllProductsByCompany/{company}")
	    @Produces({ MediaType.APPLICATION_JSON})
	    public List<Product> getAllProdctsByCompany(@PathParam("company") String company) {
	        return dao.getProductsByCompany(company);
	    }
}
