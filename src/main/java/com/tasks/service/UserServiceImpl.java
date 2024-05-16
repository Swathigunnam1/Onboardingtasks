package com.tasks.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tasks.bo.UserBO;
import com.tasks.entity.User;
import com.tasks.mapper.UserMapper;
import com.tasks.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;




@Slf4j
@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserBO createUser(UserBO userBO) {
		log.info("inside user service");
		
		User user = UserMapper.INSTANCE.toEntity(userBO);
		user.setCreationDate(new Date());
		User newUser = userRepository.save(user);
		
		 return UserMapper.INSTANCE.toBO(newUser);
    }

	@Override
    public UserBO getById(long id) {
		 
	        
	        return userRepository.findById(id)
	                .map(UserMapper.INSTANCE::toBO)
	                .orElse(null);
	    }
                
    
	 
	@Override
    public boolean isServiceUp() {
        // Add logic to check the availability of the service
        return true; // Return true if service is up; otherwise, return false
    }
	
	
	
	
	
	
	

}
