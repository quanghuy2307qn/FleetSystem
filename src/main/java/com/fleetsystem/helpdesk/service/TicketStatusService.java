package com.fleetsystem.helpdesk.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fleetsystem.helpdesk.models.TicketStatus;
import com.fleetsystem.helpdesk.repository.TicketStatusRepository;

public class TicketStatusService {

	@Autowired
	private TicketStatusRepository ticketStatusRepository;
	
	//Get All TicketStatuss
	public List<TicketStatus> findAll(){
		return ticketStatusRepository.findAll();
	}	
	
	//Get TicketStatus By Id
	public Optional<TicketStatus> findById(int id) {
		return ticketStatusRepository.findById(id);
	}	
	
	//Delete TicketStatus
	public void delete(int id) {
		ticketStatusRepository.deleteById(id);
	}
	
	//Update TicketStatus
	public void save( TicketStatus ticketStatus) {
		ticketStatusRepository.save(ticketStatus);
	}
}
