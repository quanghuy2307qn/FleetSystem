package com.fleetsystem.accounts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetsystem.accounts.models.Invoice;
import com.fleetsystem.accounts.repositories.InvoiceRepository;
import com.fleetsystem.fleet.model.Vehicle;

@Service
public class InvoiceService {
	@Autowired
	private InvoiceRepository invoiceRepository;

	// Return list of invoice
	public List<Invoice> getAll() {
		return invoiceRepository.findAll();
	}

	// Save
	public void save(Invoice invoice) {
		invoiceRepository.save(invoice);
	}

	// Get Vehicle By Id
	public Invoice findById(int id) {
		return invoiceRepository.findById(id).orElse(null);
	}

	// Delete Invoice
	public void delete(int id) {
		invoiceRepository.deleteById(id);
	}

}
