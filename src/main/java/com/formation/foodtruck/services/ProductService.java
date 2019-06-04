package com.formation.foodtruck.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.formation.foodtruck.dao.ProductDAO;
import com.formation.foodtruck.entities.Product;

@Path("/product")
public class ProductService {

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllProducts() {
		
		ProductDAO pDao = new ProductDAO();
		List<Product> lstProduct = pDao.getAllProducts();
		
		GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(lstProduct) {};

		return Response.status(Response.Status.OK).entity(entity).build();

	}
	
	@GET
	@Path("/family/{family_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findProductsByFamily(@PathParam("family_id") Integer familyId) {
		
		ProductDAO pDao = new ProductDAO();
		List<Product> lstProduct = pDao.getProductsByFamily(familyId);
		
		GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(lstProduct) {};

		return Response.status(Response.Status.OK).entity(entity).build();

	}

}
