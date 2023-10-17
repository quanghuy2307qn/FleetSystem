package com.fleetsystem.hr.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleetsystem.hr.models.Employee;
import com.fleetsystem.hr.repositories.EmployeeRepository;
import com.fleetsystem.parameters.models.Client;
import com.fleetsystem.user.model.User;
import com.fleetsystem.user.repository.UserRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	// Get All Client
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	// Get Employee By Id
	public Employee findById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}

	// Save employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}


	// Delete Employee
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}

	public Employee findByUsername(String un) {

		return employeeRepository.findByUsername(un);
	}
	
	//Set the Username of the employee where firstname and lastname match
	public void assignUsername(int id) {
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(employee.getFirstname(), employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
	
}
