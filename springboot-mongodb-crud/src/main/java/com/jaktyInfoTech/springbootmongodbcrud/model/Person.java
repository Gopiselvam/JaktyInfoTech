package com.jaktyInfoTech.springbootmongodbcrud.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Bank Users")
public class Person {
	
	private int custId;
	private String name;
	private String email;
	private String contactNo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dob;
	private String status;
	private double outstanding;

}
