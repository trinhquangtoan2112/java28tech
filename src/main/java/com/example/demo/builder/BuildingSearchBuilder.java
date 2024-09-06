package com.example.demo.builder;

import java.util.ArrayList;
import java.util.List;

public class BuildingSearchBuilder {
	private String name;
	private String street;
	private String ward;
	private Integer districtid;
	private Integer numberofbasement;
	private Integer floorarea;
	private String level;
	private Integer rentpricefrom;
	private Integer rentpriceto;
	private Integer rentareafrom;
	private Integer rentareato;
	private Long brokeragefee;
	private String managername;
	private String managerphonenumber;
	private Integer staffid;
	private List<String> typeBuilding = new ArrayList();
	
	public BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.street = builder.street;
		this.ward = builder.ward;
		this.districtid = builder.districtid;
		this.numberofbasement = builder.numberofbasement;
		this.floorarea = builder.floorarea;
		this.level = builder.level;
		this.rentpricefrom = builder.rentpricefrom;
		this.rentpriceto = builder.rentpriceto;
		this.rentareafrom = builder.rentareafrom;
		this.rentareato = builder.rentareato;
		this.brokeragefee = builder.brokeragefee;
		this.managername = builder.managername;
		this.managerphonenumber = builder.managerphonenumber;
		this.staffid = builder.staffid;
		this.typeBuilding = builder.typeBuilding;
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
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public Integer getDistrictid() {
		return districtid;
	}
	public void setDistrictid(Integer districtid) {
		this.districtid = districtid;
	}
	public Integer getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(Integer numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public Integer getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(Integer floorarea) {
		this.floorarea = floorarea;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRentpricefrom() {
		return rentpricefrom;
	}
	public void setRentpricefrom(Integer rentpricefrom) {
		this.rentpricefrom = rentpricefrom;
	}
	public Integer getRentpriceto() {
		return rentpriceto;
	}
	public void setRentpriceto(Integer rentpriceto) {
		this.rentpriceto = rentpriceto;
	}
	public Integer getRentareafrom() {
		return rentareafrom;
	}
	public void setRentareafrom(Integer rentareafrom) {
		this.rentareafrom = rentareafrom;
	}
	public Integer getRentareato() {
		return rentareato;
	}
	public void setRentareato(Integer rentareato) {
		this.rentareato = rentareato;
	}
	public Long getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(Long brokeragefee) {
		this.brokeragefee = brokeragefee;
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
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public List<String> getTypeBuilding() {
		return typeBuilding;
	}
	public void setTypeBuilding(List<String> typeBuilding) {
		this.typeBuilding = typeBuilding;
	}
	public static class Builder{
		private String name;
		private String street;
		private String ward;
		private Integer districtid;
		private Integer numberofbasement;
		private Integer floorarea;
		private String level;
		private Integer rentpricefrom;
		private Integer rentpriceto;
		private Integer rentareafrom;
		private Integer rentareato;
		private Long brokeragefee;
		private String managername;
		private String managerphonenumber;
		private Integer staffid;
		private List<String> typeBuilding = new ArrayList();
		
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setDistrictid(Integer districtid) {
			this.districtid = districtid;
			return this;
		}
		public Builder setNumberofbasement(Integer numberofbasement) {
			this.numberofbasement = numberofbasement;
			return this;
		}
		public Builder setFloorarea(Integer floorarea) {
			this.floorarea = floorarea;
			return this;
		}
		public Builder setLevel(String level) {
			this.level = level;
			return this;
		}
		public Builder setRentpricefrom(Integer rentpricefrom) {
			this.rentpricefrom = rentpricefrom;
			return this;
		}
		public Builder setRentpriceto(Integer rentpriceto) {
			this.rentpriceto = rentpriceto;
			return this;
		}
		public Builder setRentareafrom(Integer rentareafrom) {
			this.rentareafrom = rentareafrom;
			return this;
		}
		public Builder setRentareato(Integer rentareato) {
			this.rentareato = rentareato;
			return this;
		}
		public Builder setBrokeragefee(Long brokeragefee) {
			this.brokeragefee = brokeragefee;
			return this;
		}
		public Builder setManagername(String managername) {
			this.managername = managername;
			return this;
		}
		public Builder setManagerphonenumber(String managerphonenumber) {
			this.managerphonenumber = managerphonenumber;
			return this;
		}
		public Builder setStaffid(Integer staffid) {
			this.staffid = staffid;
			return this;
		}
		public Builder setTypeBuilding(List<String> typeBuilding) {
			this.typeBuilding = typeBuilding;
			return this;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
		
		
	}
}
