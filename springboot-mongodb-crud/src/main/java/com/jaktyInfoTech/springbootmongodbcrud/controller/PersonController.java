package com.jaktyInfoTech.springbootmongodbcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.springbootmongodbcrud.model.Person;
import com.jaktyInfoTech.springbootmongodbcrud.repository.PersonRepo;

@RestController
@RequestMapping("/jaktyInfoTech")
public class PersonController {
	
	@Autowired
	private PersonRepo personRepo;
	
	@PostMapping("/mogodb/savePerson")
	public Person savePerson(@RequestBody Person person) {
		Person p = personRepo.save(person);
		System.out.println("Inserted value = "+p.toString());
		return p;
	}
	
	@PostMapping("/mogodb/savePersonList")
	public List<Person> savePersonList(@RequestBody List<Person> persons) {
		List<Person> reslist = personRepo.saveAll(persons);
		System.out.print("List of Person inserted\n==========================================================\n");
		reslist.stream().forEach(p -> System.out.println(p.toString()));
		return reslist;
	}
	
	@GetMapping("/mogodb/getPerson/{id}")
	public  List<Person> getPerson(@PathVariable int id) {
		 List<Person> res = personRepo.findByCustId(id);
		System.out.println("Details of person with id ("+id+") = "+res.toString());
		return res;
		
	}
	
	@DeleteMapping("/mogodb/deletePerson/{id}")
	public List<Person> deletePerson(@PathVariable int id) {
		List<Person> temp = personRepo.findByCustId(id);
		 personRepo.deleteByCustId(id);
		 System.out.println("deleted data for id ("+id+") = "+temp.toString());
		 return temp;
	}
	
	@GetMapping("/mogodb/getPersonByName/{name}")
	public List<Person> getPersonByName(@PathVariable("name") String custName) {
		List<Person> res = personRepo.findByName(custName);
		System.out.println("Details of person with name ("+custName+") = "+res.toString());
		return res;
		
	}
	
	@DeleteMapping("/mogodb/deletePersonByName/{name}")
	public List<Person> deletePersonByName(@PathVariable("name") String custName) {
		List<Person> temp = personRepo.findByName(custName);
		 personRepo.deleteByName(custName);
		 System.out.println("deleted data for id ("+custName+") = "+temp.toString());
		 return temp;
	}
	
	@GetMapping("/mogodb/getNonPaidPersons")
	public List<Person> getNonPaidPersons() {
		List<Person> res = personRepo.findPaymentDuePersons();
		
		res.forEach(p -> System.out.println("Details of persons who doesn't pay amount = "+p.toString()));;
		return res;
		
	}
	
	@GetMapping("/mogodb/getByRegex")
	public List<Person> getByRegex() {
		List<Person> res = personRepo.findByRegex();
		
		res.forEach(p -> System.out.println("Details of persons enlisted by regex = "+p.toString()));;
		return res;
		
	}

}
