package com.fleetsystem.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.fleetsystem.user.model.User;
import com.fleetsystem.user.service.MyUserDetailService;
import com.fleetsystem.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public String getCountries() {
		return "User";
	}
	
	@PostMapping(value="users/addNew")
	public RedirectView addNew(User user, RedirectAttributes redir) {
		userService.save(user);
		
		RedirectView redirectView = new RedirectView("/login",true);
		redir.addFlashAttribute("message","You successfully registered! You can now login");
		
		return redirectView;
	}

	
}
