package com.sathyatech.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathyatech.app.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRoleName(String roleName);
}
