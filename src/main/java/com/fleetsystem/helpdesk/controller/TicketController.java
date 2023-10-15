package com.fleetsystem.helpdesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fleetsystem.helpdesk.service.TicketService;
import com.fleetsystem.helpdesk.service.TicketStatusService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketStatusService ticketStatusService;
	
	
}
