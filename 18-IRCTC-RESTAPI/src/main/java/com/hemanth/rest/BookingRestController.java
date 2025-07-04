package com.hemanth.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.binding.Passenger;
import com.hemanth.response.Ticket;
import com.hemanth.service.BookingService;
import com.hemanth.service.BookingServiceImpl;

@RestController
public class BookingRestController {
	
	@Autowired
	private BookingService service;
	
	
	@PostMapping(value = "/ticket",
				consumes = {"application/json"},
				produces = {"application/json"}
			)
	public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger)
	{
		Ticket ticket = service.bookTicket(passenger);
		
		return new ResponseEntity<>(ticket, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/ticket/{ticketNum}",
				produces = {"application/json"}
			)
	public ResponseEntity<Ticket> getTicket(@PathVariable("ticketNum") Integer ticketNum)
	{
		Ticket ticket = service.getTicket(ticketNum);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);
	}
}
