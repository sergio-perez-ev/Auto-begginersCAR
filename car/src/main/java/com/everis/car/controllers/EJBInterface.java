package com.everis.car.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.persistence.TypedQuery;

import com.everis.car.model.Car;

public interface EJBInterface {
	public List<Car> getCars();
	public Car getCar(UUID id);
	public UUID createCar(String brand, String country, Timestamp registration);
	public boolean updateCar(UUID id, Car car);
	public boolean deleteCar(UUID id);
	
}
