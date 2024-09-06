package com.example.demo.repository.entity;

import java.util.Date;

public class BuildingEntity {
	private Integer id;
	private String createdate;
	private String name;
	private String street;
	private Long districtid;
	private String managername;
	private String managerphonenumber;
	private Long floorarea;
	private Long rentprice;
	private Integer numberofbasement;
	private String ward;
	private String rentarea;
	private String emptyArea;
	private Long servicefee;
	private Long brokeragefee;
	
	public String getEmptyArea() {
		return emptyArea;
	}

	public void setEmptyArea(String emptyArea) {
		this.emptyArea = emptyArea;
	}

	public BuildingEntity() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createddate) {
		this.createdate = createddate;
	}

	public Long getDistrictid() {
		return districtid;
	}

	public void setDistrictid(Long districtid) {
		this.districtid = districtid;
	}

	public String getManagername() {
		return managername;
	}

	public void setManagername(String managername) {
		this.managername = managername;
	}

	public String getManagerphonenumber() {
		return managerphonenumber;
	}

	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}

	public Long getFloorarea() {
		return floorarea;
	}

	public void setFloorarea(Long floorarea) {
		this.floorarea = floorarea;
	}

	public Long getRentprice() {
		return rentprice;
	}

	public void setRentprice(Long rentprice) {
		this.rentprice = rentprice;
	}

	public String getRentarea() {
		return rentarea;
	}

	public void setRentarea(String rentarea) {
		this.rentarea = rentarea;
	}

	public Long getServicefee() {
		return servicefee;
	}

	public void setServicefee(Long servicefee) {
		this.servicefee = servicefee;
	}

	public Long getBrokeragefee() {
		return brokeragefee;
	}

	public void setBrokeragefee(Long brokeragefee) {
		this.brokeragefee = brokeragefee;
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
