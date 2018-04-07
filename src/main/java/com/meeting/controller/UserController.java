package com.meeting.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.meeting.model.User;

@Controller
public class UserController {

	@GetMapping("/")
	public String home() {
		return "about";
	}
	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/services")
	public String servives() {
		return "services";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute User user, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "registration";
		}
				
		
		return "registration";
	}
}
