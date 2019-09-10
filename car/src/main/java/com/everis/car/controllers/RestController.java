package com.everis.car.controllers;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.everis.car.model.Car;

@Path("/carService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RestController {
	@GET
	public Response getCars() {
		
	}
	@GET(path)
	public Response getCarById(UUID id) {
		
	}
	@POST
	public Response createCar() {
		
	}
	@PUT
	public Response modifyCar(UUID id, Car car) {
		
	}
	@DELETE
	public Response deleteCar(UUID id) {
		
	}
}
