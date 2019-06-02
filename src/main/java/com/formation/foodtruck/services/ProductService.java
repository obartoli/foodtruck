package com.formation.foodtruck.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.formation.foodtruck.entities.Product;
import com.formation.foodtruck.utils.HibernateUtils;

@Path("/product")
public class ProductService {

	private Session session = null;
//	private Transaction transaction = null;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {

		session = HibernateUtils.getSession();
		
		Query<Product> query = session.createNamedQuery(
				"Product.findAll",
				Product.class);

		List<Product> lstProduct = query.getResultList();

		session.close();
		
		GenericEntity<List<Product>> entity = new GenericEntity<List<Product>>(lstProduct) {};

		return Response.status(Response.Status.OK).entity(entity).build();

	}

}
