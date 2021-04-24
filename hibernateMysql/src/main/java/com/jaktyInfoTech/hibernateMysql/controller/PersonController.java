package com.jaktyInfoTech.hibernateMysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.hibernateMysql.dao.PersonDao;
import com.jaktyInfoTech.hibernateMysql.model.Person;

@RestController
@RequestMapping("/hibernateMysql")
public class PersonController {
	
	@Autowired
	private PersonDao personDao;
	
	@PostMapping("/savePerson")
	public String savePerson(@RequestBody Person person) {
		personDao.savePerson(person);
		return "success";
	}
	
	@GetMapping("/getPersons")
	public List<Person> getAllPersons(){
		return personDao.getPersons();
	}

}
