package com.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.entity.User;



@Repository
public interface UserRepository extends JpaRepository <User,Long>{
	
	
	

}
