package com.fleetsystem.profile;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fleetsystem.hr.services.EmployeeService;

@Controller
public class ProfileController {
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/profile")
	public String pofile(Model model,Principal principal ) {
		String un = principal.getName();
		model.addAttribute("employee",employeeService.findByUsername(un));
		
		return "/assets/profile";
	}
}
