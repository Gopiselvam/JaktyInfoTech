package com.jaktyInfoTech.springmysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.springmysql.dao.TicketDao;
import com.jaktyInfoTech.springmysql.model.Ticket;



@RestController
@RequestMapping("/jaktyInfoTech")
public class TicketController {
	
	@Autowired
	private TicketDao ticketDao;
	
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets) {
		
		ticketDao.saveAll(tickets);
		return "tickets booked"+tickets.size();
	}
	
	
	@GetMapping("/getTickets")
	public List<Ticket> getTickets(){
		return (List<Ticket>) ticketDao.findAll();
	}

}
