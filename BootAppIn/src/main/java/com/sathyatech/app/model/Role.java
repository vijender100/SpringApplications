package com.sathyatech.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles_tab")
public class Role {
	
	@Id
	@Column(name="r_id")
	@GeneratedValue
	private int roleId;
	
	@Column(name="r_name")
	private String roleName;
	
	public Role() {
		super();
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return roleName;
	}
	
	
	
}
