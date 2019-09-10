package com.everis.car.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class EJBController {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("");
	public List<Car> getCars(){
		
	}
	public Car getCar(UUID id) {
		
	}
	public UUID createCar(Car car) {
		
	}
	public boolean updateCar(Car car) {
		
	}
	public boolean deleteCar(UUID id) {
		
	}
	
}
