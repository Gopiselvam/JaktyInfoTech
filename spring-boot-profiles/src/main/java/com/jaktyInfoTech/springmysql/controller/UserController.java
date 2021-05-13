package com.jaktyInfoTech.springmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.springmysql.model.Users;
import com.jaktyInfoTech.springmysql.service.UserService;

@RestController
@RequestMapping("/jaktyInfoTech")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
}
