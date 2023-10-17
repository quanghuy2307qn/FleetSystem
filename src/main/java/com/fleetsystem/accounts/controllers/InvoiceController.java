package com.fleetsystem.accounts.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fleetsystem.accounts.models.Invoice;
import com.fleetsystem.accounts.services.InvoiceService;
import com.fleetsystem.accounts.services.InvoiceStatusService;
import com.fleetsystem.fleet.model.Vehicle;
import com.fleetsystem.parameters.services.ClientService;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceService invoiceService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoices")
	public String getAll(Model model) {
		List<Invoice> listInvoices = invoiceService.getAll();
		model.addAttribute("invoices", listInvoices);

		return "accounts/invoice/invoiceList";
	}

	@GetMapping("/invoiceAdd")
	public String addInvoice(Model model) {
		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("statuses", invoiceStatusService.findAll());

		return "accounts/invoice/invoiceAdd";
	}

	@PostMapping("/saveInvoice")
	public String save(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}

	@RequestMapping(value = "/invoice/edit/{id}", method = RequestMethod.GET)
	public String editInvoice(Model model, @PathVariable Integer id) {
		Invoice invoice = invoiceService.findById(id);
		model.addAttribute("invoice", invoice);

		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("statuses", invoiceStatusService.findAll());

		return "accounts/invoice/invoiceEdit";
	}

	@PostMapping("/updateInvoice")
	public String updateVehicle(Invoice invoice) {
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}

	@RequestMapping(value = "/invoice/detail/{id}", method = RequestMethod.GET)
	public String detailInvoice(Model model, @PathVariable Integer id) {
		Invoice invoice = invoiceService.findById(id);
		model.addAttribute("invoice", invoice);

		model.addAttribute("clients", clientService.findAll());
		model.addAttribute("statuses", invoiceStatusService.findAll());

		return "accounts/invoice/invoiceDetail";
	}

	@RequestMapping(value = "/invoice/delete{id}", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteInvoice(@PathVariable Integer id) {
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
