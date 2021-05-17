package com.jaktyInfoTech.springbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jaktyInfoTech")
public class ApplicationController {
	
	@GetMapping("/authorize/greetings")
	public String greetings() {
		return "Welcome to JaktyInfoTech";
	}

}
