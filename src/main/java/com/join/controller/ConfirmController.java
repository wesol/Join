package com.join.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.join.service.UserService;

@Controller
public class ConfirmController extends WebMvcConfigurerAdapter {
	private UserService userService;

	@Autowired
	public ConfirmController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/confirm")
	public String confirm(@RequestParam Long id, @RequestParam String configurationId, Model model) {
		model.addAttribute("info", userService.activateUser(id,configurationId));
		return "confirm";
	}
}
