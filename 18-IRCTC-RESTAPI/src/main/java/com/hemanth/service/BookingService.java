package com.hemanth.service;

import com.hemanth.binding.Passenger;
import com.hemanth.response.Ticket;

public interface BookingService {
	
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
}
