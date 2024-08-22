package com.example.demo.repository.entity;

import java.util.Date;

public class BuildingEntity {
	
	private String name;
	private String street;
	private Integer numberofbasement;
	private String ward;

	public BuildingEntity(String name, String street, Integer numberofbasement, String ward) {
		super();
		this.name = name;
		this.street = street;
		this.numberofbasement = numberofbasement;
		this.ward = ward;
	}
	public BuildingEntity() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	
}
