package com.formation.foodtruck.services;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/service")
public class Service {

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public Response testXml() {
		String entity = "<xml><txt>blabla<tt>opop</tt></txt></xml>";
		return Response.status(Response.Status.OK).entity(entity).build();
	}
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testJson() {
		String entity = "{\"blabla\": \"item1\"}";
		return Response.status(Response.Status.ACCEPTED).entity(entity).build();
	}
	
	@GET
	@Path("/txt")
	@Produces(MediaType.TEXT_PLAIN)
	public Response test() {
		String entity = "blabla";
		return Response.status(Response.Status.ACCEPTED).entity(entity).build();
	}
}
