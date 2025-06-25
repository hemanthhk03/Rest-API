package com.hemanth.service;

import java.beans.Beans;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemanth.binding.Passenger;
import com.hemanth.repo.TicketRepository;
import com.hemanth.response.Ticket;


@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private TicketRepository repo;
	
	private Integer ticketNum=1;
	@Override
	public Ticket bookTicket(Passenger passenger) {
		
		//logic
		Ticket t=new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(155.00);
		t.setStatus("CONFIRMED");
		t.setTicketNumber(ticketNum);
		repo.save(t);
		ticketNum++;
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		
		if(repo.existsById(ticketNumber))
		{
			Optional<Ticket> byId = repo.findById(ticketNumber);
			Ticket ticket = byId.get();
			return ticket;
		}
		
		return null;
	}

}
