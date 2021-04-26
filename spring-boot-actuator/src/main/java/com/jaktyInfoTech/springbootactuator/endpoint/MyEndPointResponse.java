package com.jaktyInfoTech.springbootactuator.endpoint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
public class MyEndPointResponse{
	public MyEndPointResponse(int id, String name, String status) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name= name;
		this.status = status;
	}
	private int id;
	private String name;
	private String status;
}