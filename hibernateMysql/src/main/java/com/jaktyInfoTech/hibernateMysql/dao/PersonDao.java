package com.jaktyInfoTech.hibernateMysql.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jaktyInfoTech.hibernateMysql.model.Person;

@Repository
@Transactional
public class PersonDao {
	
	@Autowired
	private SessionFactory factory;
	
	@SuppressWarnings("unchecked")
	private Session getSession() {
		Session session = factory.getCurrentSession();
		if(null == session) {
			session = factory.openSession();
		}
		return session;
	}
	
	public void savePerson(Person person) {
		getSession().save(person);
	}
	
	
	public List<Person> getPersons(){
		return getSession().createCriteria(Person.class).list();
	}
}
