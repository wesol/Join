package com.join.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.join.model.User;
import com.join.service.EmailService;
import com.join.service.UserService;

@Controller
public class UserController extends WebMvcConfigurerAdapter {

	private UserService userService;
	private EmailService emailService;

	@Autowired
	public UserController(UserService userService, EmailService emailService) {
		this.userService = userService;
		this.emailService = emailService;

	}

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
		model.addAttribute("info", "Fields with '*' cannot be empty");
		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute User user, BindingResult result, Model model,
			@RequestParam String confirmPassword) {

		if (result.hasErrors()) {
			return "registration";
		}

		if (userService.isNewUserExists(user.getEmail())) {
			result.rejectValue("email", "error.user.exists", "There is already a user registered with ");
			return "registration";
		}

		if (!user.getPassword().equals(confirmPassword)) {
			model.addAttribute("confirmPasswordMessage", "Passwords must be the same");
			return "registration";
		}

		user.setRegDate(java.time.LocalDateTime.now());
		user.setConfigurationId(java.util.UUID.randomUUID().toString());
		userService.addUser(user);
		emailService.send(user.getEmail(), "TEST",
				"http://localhost:8080/confirm?id=" + user.getId() + "&configurationId="+user.getConfigurationId());
		model.addAttribute("successMessage",
				"User has been registered succesfully.<br/>Activation link has been sent to the address: "
						+ user.getEmail() + ".<br/>It will be active for 24 hours ");
		model.addAttribute("user", new User());
		return "registration";

	}
}
