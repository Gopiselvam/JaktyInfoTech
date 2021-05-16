package com.jaktyInfoTech.sprinbatchmongodb.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Bank Users")
public class Person {
	
	private int custId;
	private String name;
	private String email;
	private String conactNo;
	private Date dob;
	private String status;
	private double outstanding;
	

}
