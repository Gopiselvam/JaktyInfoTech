package com.jaktyInfoTech.springmysql.dao;

import org.springframework.data.repository.CrudRepository;

import com.jaktyInfoTech.springmysql.model.Ticket;

public interface TicketDao extends CrudRepository<Ticket, Integer>{

}
