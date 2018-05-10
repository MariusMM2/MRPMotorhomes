package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.repositories.CrudRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {

	protected CrudRepository repository;

	/**
	 * 
	 * @param model
	 */
	@GetMapping("/")
	public String login(Model model) {
		// TODO - implement Controller.login
		throw new UnsupportedOperationException();
	}

}