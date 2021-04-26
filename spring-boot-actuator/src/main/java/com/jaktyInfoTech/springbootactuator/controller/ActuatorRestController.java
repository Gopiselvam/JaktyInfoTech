package com.jaktyInfoTech.springbootactuator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actuatorApp")
public class ActuatorRestController {
	
	@GetMapping("/testActuator")
	public String testActuator() {
		
		return "Actuator test End point";
	}

}
