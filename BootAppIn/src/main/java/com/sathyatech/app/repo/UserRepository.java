package com.sathyatech.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sathyatech.app.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	 User findByUserEmail(String email);
}
