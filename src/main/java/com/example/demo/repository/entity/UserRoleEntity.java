package com.example.demo.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRoleEntity {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity users;

	@ManyToOne
  @JoinColumn(name = "role_id")
  private RoleEntity roles;

  public UserEntity getUsers() {
      return users;
  }

  public void setUsers(UserEntity users) {
      this.users = users;
  }

  public RoleEntity getRoles() {
      return roles;
  }

  public void setRoles(RoleEntity roles) {
      this.roles = roles;
  }

  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
