package com.example.demo.repository.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "createdate")
	private String createdate;
	@Column(name = "name")
	private String name;
	@Column(name = "street")
	private String street;

	@Column(name = "managername")
	private String managername;
	@Column(name = "managerphonenumber")
	private String managerphonenumber;
	@Column(name = "floorarea")
	private Long floorarea;
	@Column(name = "rentprice")
	private Long rentprice;
	@Column(name = "numberofbasement")
	private Integer numberofbasement;
	@Column(name = "ward")
	private String ward;
	@Column(name = "rentarea")
	private String rentarea;
	@Column(name = "emptyArea")
	private String emptyArea;
	@Column(name = "servicefee")
	private Long servicefee;
	@Column(name = "brokeragefee")
	private Long brokeragefee;
	@Column(name = "test")
	private String test;

	@ManyToOne
	@JoinColumn(name = "districtid")
//	@Column(name = "districtid")
	private DistrictEntity district;
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> items = new ArrayList<>();

	public String getTest() {
		return test;
	}

	public List<RentAreaEntity> getItems() {
		return items;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public void setItems(List<RentAreaEntity> items) {
		this.items = items;
	}

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

	public DistrictEntity getDistrictid() {
		return district;
	}

	public void setDistrictid(DistrictEntity districtid) {
		this.district = districtid;
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
