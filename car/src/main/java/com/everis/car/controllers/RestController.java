package com.everis.car.controllers;

import java.net.URI;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.everis.car.model.Car;
import com.google.gson.JsonObject;

@Path("/carService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestController {
	//@Inject
	@EJB(beanName="EJBController")
	EJBInterface controller;
	@GET
	public Response getCars() {
		List<Car> cars=controller.getCars();
		JsonObject car=new JsonObject();
		for (Car c : cars) {
			car.addProperty("brand",c.getBrand());
			car.addProperty("country",c.getCountry());
		}
		return Response.ok(car.toString(), MediaType.APPLICATION_JSON).build();
	}
	@GET
	@Path(value = "/{id}")
	public Response getCarById(@QueryParam(value = "id") UUID id) {
		Car c=controller.getCar(id);
		JsonObject car=new JsonObject();
		car.addProperty("brand",c.getBrand());
		car.addProperty("country",c.getCountry());
		return Response.ok(car.toString(), MediaType.APPLICATION_JSON).build();
	}
	@POST
	public Response createCar(String brand, String country, Timestamp registration) {
		UUID id=controller.createCar(brand, country, registration);
		return Response.created(URI.create(id.toString())).build();
	}
	@PUT
	@Path(value="/{id}")
	public Response modifyCar(UUID id, Car car) {
		if(controller.updateCar(id,car))
			return Response.noContent().build();
		return Response.notModified().build();
	}
	@DELETE
	public Response deleteCar(UUID id) {
		controller.deleteCar(id);
		return Response.noContent().build();
	}
}
