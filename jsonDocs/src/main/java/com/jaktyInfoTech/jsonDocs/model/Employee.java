package com.jaktyInfoTech.jsonDocs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ApiObject
public class Employee {
	@Id
	@GeneratedValue
	@ApiObjectField(name="employee id", description="Auto generated id")
	private int id;
	@ApiObjectField(name="employee name", description="full name of the employee")
	@JsonProperty("employee name")
	private String name;
	@ApiObjectField(name="employee dept", description="current employee department")
	@JsonProperty("employee dept")
	private String dept;
	@ApiObjectField(name="employee salary", description="Current CTC")
	@JsonProperty("employee salary")
	private Double salary;

}
