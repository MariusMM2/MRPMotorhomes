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
		model.addAttribute("users", new User[]{User.ALL_USERS[1], User.ALL_USERS[2]});
		return "index";
	}

}