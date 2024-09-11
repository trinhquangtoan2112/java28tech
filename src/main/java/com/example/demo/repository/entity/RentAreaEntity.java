package com.example.demo.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RentArea")
public class RentAreaEntity {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "value")
     private String value;

	
	@ManyToOne
	@JoinColumn(name ="buildingId")
	private BuildingEntity building;
	public Integer getId() {
		return id;
	}

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
     
}
