package com.jaktyInfoTech.jsonDocs.controller;

import java.util.List;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiVisibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.jsonDocs.model.Employee;
import com.jaktyInfoTech.jsonDocs.service.EmployeeService;

@RestController
@Api(name = "EMployee management portal", description = "Employee information available", visibility = ApiVisibility.PUBLIC, group = "Management")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping(value = "/addEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ApiMethod(description="add new employee")
	public void postEmployee(@RequestBody Employee employee) {
		service.saveEmployee(employee);
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	@ApiMethod(description="get employee by using id", path= {"id"})
	public Employee getEmployee(@PathVariable int id) {
		return service.getEmployee(id);
	}

	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
	@ApiMethod(description="delete employee by id")
	public List<Employee> deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}

}
