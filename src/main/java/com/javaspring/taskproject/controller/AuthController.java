package com.javaspring.taskproject.controller;

import org.hibernate.bytecode.spi.ReflectionOptimizer.AccessOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.taskproject.entity.Users;
import com.javaspring.taskproject.payload.LoginDto;
import com.javaspring.taskproject.payload.UserDto;
import com.javaspring.taskproject.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
    public UserService userService;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	
//post store the user id db
	@PostMapping("/register")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
     return new ResponseEntity<>(userService.createUser(userDto),HttpStatus.CREATED);
     //store the data user dto into userdata,,,,,,,create stsus code 201 sussccussss code 
	
	}
	@PostMapping("/login")
	public ResponseEntity<String>loginUser(@RequestBody LoginDto loginDto){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));
		System.out.println(authentication);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return new ResponseEntity<>("User Logged in Successfully",HttpStatus.OK);
	}
}
