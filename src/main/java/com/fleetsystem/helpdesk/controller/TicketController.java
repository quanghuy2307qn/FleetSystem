package com.fleetsystem.helpdesk.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleetsystem.helpdesk.models.Ticket;
import com.fleetsystem.helpdesk.service.TicketService;
import com.fleetsystem.helpdesk.service.TicketStatusService;
import com.fleetsystem.parameters.services.ClientService;

@Controller
public class TicketController {
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketStatusService ticketStatusService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/tickets")
	public String getAll(Model model) {
		model.addAttribute("clients",clientService.findAll());
		model.addAttribute("ticketStatuses",ticketStatusService.findAll());
		model.addAttribute("tickets",ticketService.findAll());
		
		return "helpdesk/ticket/ticketList";
	}
	//Add Ticket
		@PostMapping(value="/addNew")
		public String addNew(Ticket ticket) {
			ticketService.save(ticket);
			return "redirect:/tickets";
		}
		
		@RequestMapping(value="/updateTicket", method = {RequestMethod.PUT, RequestMethod.GET})
		public String update(Ticket ticket) {
			ticketService.save(ticket);
			return "redirect:/tickets";
		}
		@RequestMapping(value="/deleteTicket", method = {RequestMethod.DELETE, RequestMethod.GET})
		public String delete(Integer id) {
			ticketService.delete(id);
			return "redirect:/tickets";
		}
		
		@RequestMapping("/tickets/findById")
		@ResponseBody
		public Optional<Ticket> findById(Integer id)
		{
			return ticketService.findById(id);
		}
}
