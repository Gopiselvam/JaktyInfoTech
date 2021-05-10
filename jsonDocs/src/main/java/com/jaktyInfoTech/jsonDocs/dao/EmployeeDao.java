package com.jaktyInfoTech.jsonDocs.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaktyInfoTech.jsonDocs.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
