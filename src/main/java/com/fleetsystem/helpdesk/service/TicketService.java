package com.fleetsystem.helpdesk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetsystem.helpdesk.models.Ticket;
import com.fleetsystem.helpdesk.repository.TicketRepository;

@Service
public class TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	//Get All Tickets
	public List<Ticket> findAll(){
		return ticketRepository.findAll();
	}	
	
	//Get Ticket By Id
	public Optional<Ticket> findById(int id) {
		return ticketRepository.findById(id);
	}	
	
	//Delete Ticket
	public void delete(int id) {
		ticketRepository.deleteById(id);
	}
	
	//Update Ticket
	public void save(Ticket invoice) {
		ticketRepository.save(invoice);
	}
}
