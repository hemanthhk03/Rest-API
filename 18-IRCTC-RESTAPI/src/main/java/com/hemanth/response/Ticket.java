package com.hemanth.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="ticket_table")
public class Ticket {
	
	@Id
	private Integer ticketNumber;
	private String status;
	private Double ticketCost;
	private String name;
	private String fromStation;
	private String toStation;
	private String doj;
	private String trainNumber;
}
