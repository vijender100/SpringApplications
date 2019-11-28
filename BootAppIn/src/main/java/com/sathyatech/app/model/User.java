package com.sathyatech.app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usr_tab")
public class User {
	@Id
	@Column(name="u_id")
	@GeneratedValue
	private int userId;

	@Column(name="u_name")
	private String userName;

	@Column(name="u_email",unique=true)
	private String userEmail;

	@Column(name="u_pwd")
	private String password;

	@Column(name="u_active")
	private int active;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usr_role_tab",
	joinColumns=@JoinColumn(name="u_id"),
	inverseJoinColumns=@JoinColumn(name="r_id"))
	private Set<Role> roles=new HashSet<Role>(0);

	public User() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
}
