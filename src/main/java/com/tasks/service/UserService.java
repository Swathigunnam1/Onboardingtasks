package com.tasks.service;


import com.tasks.bo.UserBO;


public interface UserService {
	
	UserBO createUser(UserBO userBO);
	
	UserBO getById(long id);
	

	boolean isServiceUp();
}
