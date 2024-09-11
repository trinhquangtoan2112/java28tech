package com.example.demo.repository.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private Integer status;
	
	@Column(name = "createddate")
	private Date createddate;
	
	@Column(name = "modifieddate")
	private Date modifieddate;
	
	@Column(name = "createdby")
	private String createdby;
	
	@Column(name = "modifiedby")
	private String modifiedby;
	
	@OneToMany(mappedBy = "users",fetch = FetchType.LAZY)
	private List<UserRoleEntity> userRoleEntities = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFullname() {
		return fullname;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public Integer getStatus() {
		return status;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public Date getModifieddate() {
		return modifieddate;
	}

	public String getCreatedby() {
		return createdby;
	}

	public String getModifiedby() {
		return modifiedby;
	}

	public List<UserRoleEntity> getUserRoleEntities() {
		return userRoleEntities;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}

	public void setUserRoleEntities(List<UserRoleEntity> userRoleEntities) {
		this.userRoleEntities = userRoleEntities;
	}

	
}
