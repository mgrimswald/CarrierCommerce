package com.carrierinfo.carriercommerce.dao;

import com.carrierinfo.carriercommerce.model.User;

public interface UserDao {

	User authenticate(String username, String password);
	User register(User user);
	User findUserByUsername(String username);
	
}
