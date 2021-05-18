package com.jaktyInfoTech.springstoredprocedure.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@NamedStoredProcedureQueries({ @NamedStoredProcedureQuery(name = "firstProcedure", procedureName = "getTickets"),
		@NamedStoredProcedureQuery(name = "secondProcedure", procedureName = "getTicketsByCatagory", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "tcatagory", type = String.class) }) })
public class Ticket {
	@Id
	private int id;
	private int amount;
	private String catagory;

}
