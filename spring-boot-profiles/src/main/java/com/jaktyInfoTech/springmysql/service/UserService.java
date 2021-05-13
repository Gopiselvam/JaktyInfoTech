package com.jaktyInfoTech.springmysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.jaktyInfoTech.springmysql.dao.UserRepository;
import com.jaktyInfoTech.springmysql.model.Users;

@Service
@Profile(value= {"local", "prod", "dev"})
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}

}
