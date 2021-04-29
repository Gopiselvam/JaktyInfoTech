package com.jaktyInfoTech.springbootjobSheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.jaktyInfoTech.springbootjobSheduler.dao.UserDao;
import com.jaktyInfoTech.springbootjobSheduler.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Scheduled(fixedRate = 5000)
	public void add2DBjob() {
		User user = new User();
		user.setName("USER-"+ new Random().nextInt());
		userDao.save(user);
		System.out.println("add service call in === "+ new Date().toString());
	}
	
	@Scheduled(cron= "0/15 * * * * *")
	public void fetchDBJob() {
		List<User> list = userDao.findAll();
		
		System.out.println("fetch service call in "+ new Date().toString());
		System.out.println("no of records fetched "+list.size());
		
		logger.info("User: {} " , list);
	}
	
	@Scheduled(cron= "0/5 * * * * *")
	public void deleteDBJob() {
		
	}
	
	
	

}
