package com.jaktyInfoTech.jsonDocs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaktyInfoTech.jsonDocs.dao.EmployeeDao;
import com.jaktyInfoTech.jsonDocs.model.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;
	
	public void saveEmployee(Employee employee) {
		dao.save(employee);
	}
	
	public Employee getEmployee(int id) {
		return dao.findById(id).get();
	}
	
	public List<Employee> deleteEmployee(int id){
		dao.deleteById(id);
		return dao.findAll();
	}

}
