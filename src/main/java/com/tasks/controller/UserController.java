package com.tasks.controller;


import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.bo.UserBO;
import com.tasks.entity.User;
import com.tasks.mapper.UserMapper;
import com.tasks.service.UserService;
import com.tasks.service.UserServiceImpl;
import com.tasks.util.Constants;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/user")
@Validated
public class UserController {

	@Autowired
	UserService userService;


	@PostMapping("/create")
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
	
	    UserBO userBO = UserMapper.INSTANCE.toBO(user);
	    UserBO createdUserBO = userService.createUser(userBO);
	    User createdUser = UserMapper.INSTANCE.toEntity(createdUserBO);
	    
	    return ResponseEntity.ok(createdUser);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public String handleValidationExceptions(MethodArgumentNotValidException ex) {
		return ex.getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(Collectors.joining(", "));
	}



	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long id) {
		// Call the service method to retrieve the user by ID
		UserBO user = userService.getById(id);

		// If user is found, return it along with HTTP status 200 OK
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			// If user is not found, return HTTP status 404 Not Found
			 return ResponseEntity.status(HttpStatus.NOT_FOUND)
                     .body(String.format(Constants.USER_NOT_FOUND_MESSAGE, id));		}








	}
}
