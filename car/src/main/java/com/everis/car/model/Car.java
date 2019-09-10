package com.everis.car.model;

import java.sql.Timestamp;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
@Entity
public class Car {
	@GeneratedValue
	private UUID id;
	@NotNull
	private String brand;
	@NotNull
	private Timestamp registration;
	@NotNull
	private String country;
	@NotNull @Transient
	private Timestamp created_at;
	@NotNull @Transient
	private Timestamp last_update;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Timestamp getRegistration() {
		return registration;
	}
	public void setRegistration(Timestamp registration) {
		this.registration = registration;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getLast_update() {
		return last_update;
	}
	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
}
