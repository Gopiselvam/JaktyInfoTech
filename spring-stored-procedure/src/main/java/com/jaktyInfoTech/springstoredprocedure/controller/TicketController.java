package com.jaktyInfoTech.springstoredprocedure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaktyInfoTech.springstoredprocedure.dao.TicketDao;
import com.jaktyInfoTech.springstoredprocedure.model.Ticket;

@RestController
@RequestMapping("/jaktyInfoTech")
public class TicketController {
	
	@Autowired
	private TicketDao ticketDao;
	
	@GetMapping("/findTicket")
	public List<Ticket> findTickets(){
		return ticketDao.getTicketInfo();
	}
	
	@GetMapping("/findTicket/{catagory}")
	public List<Ticket> findTickets(@PathVariable String catagory){
		return ticketDao.getTicketInfoByCatagory(catagory);
	}

}
