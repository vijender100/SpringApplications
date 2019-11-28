package com.sathyatech.app.service;

import com.sathyatech.app.model.User;

public interface IUserService {
	
	public void saveUser(User user);
	public User findUserByEmail(String email);
}
