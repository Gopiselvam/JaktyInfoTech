package com.jaktyInfoTech.springbootmongodbcrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.jaktyInfoTech.springbootmongodbcrud.model.Person;

public interface PersonRepo extends MongoRepository<Person, Integer>{
	
	List<Person> findByCustId(int id);
	
	Person deleteByCustId(int id);
	
	List<Person> findByName(String name);
	
	void deleteByName(String name);
	
	@Query("{'outstanding':{$gt : 0}}")
	List<Person> findPaymentDuePersons();
	
	@Query("{'name':{$regex:'.*selvam'}}")
	List<Person> findByRegex();

}
