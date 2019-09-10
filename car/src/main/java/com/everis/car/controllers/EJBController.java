package com.everis.car.controllers;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.everis.car.model.Car;

@Stateless
public class EJBController implements EJBInterface{
	@PersistenceContext(unitName="carPersistence") EntityManager em;
	public List<Car> getCars(){
		TypedQuery<Car> q=em.createQuery("SELECT * FROM Car",Car.class);
		List<Car> cars=q.getResultList();
		return cars;
	}
	public Car getCar(UUID id) {
		Car c=em.find(Car.class, id);
		return c;
		
	}
	public UUID createCar(String brand, String country, Timestamp registration) {
		em.getTransaction().begin();
		Car c=new Car();
		c.setBrand(brand);
		c.setCountry(country);
		c.setRegistration(registration);
		Timestamp time=new Timestamp(new Date().getTime());
		c.setCreated_at(time);
		c.setLast_update(time);
	    em.persist(c);
	    em.flush();
	    em.getTransaction().commit();
	    return c.getId();
	}
	public boolean updateCar(UUID id, Car car) {
		Car fetched=em.find(Car.class, id);
		if(fetched==null) return false;
		em.getTransaction().begin();
		fetched.setBrand(car.getBrand());
		fetched.setCountry(car.getCountry());
		fetched.setLast_update(new Timestamp(new Date().getTime()));
		em.getTransaction().commit();
		return true;
	}
	public boolean deleteCar(UUID id) {
		Car fetched=em.find(Car.class, id);
		if(fetched==null) return false;
		em.getTransaction().begin();
		em.remove(fetched);
		em.getTransaction().commit();
		return true;
	}
}
