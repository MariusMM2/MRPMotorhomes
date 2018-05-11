package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.User;
import com.mrp.motorhomes.repositories.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
	/**
	 * 
	 * @param model
	 */
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("users", User.ALL_USERS);
		return "index";
	}

}