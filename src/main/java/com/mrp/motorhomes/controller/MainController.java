package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	public static final String ERROR_MESSAGE = "All fields are required." ;
	public static final String ERROR_CUSTOMER = "Email must have  an @ and end with .com or .dk. Phone and SSN must " +
			"contain only digits";
	public static final String ERROR_RENTAL   = "Start date cannot be before today's " +
			"date, and end date cannot be before start date.";
			
	public static User currentUser = null;
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("users", User.ALL_USERS);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("type") String type){
		for(User user : User.ALL_USERS) {
			if(user.getType().equals(type)){
				currentUser = user;
			}
		}
		
		System.out.println(currentUser);
		if(currentUser.getType().equals(User.TYPES[0])){
			return "redirect:/customers/";
		}
		else if(currentUser.getType().equals(User.TYPES[2])){
			return "redirect:/rentals/";
		}
		else if(currentUser.getType().equals(User.TYPES[1]) || currentUser.getType().equals(User.TYPES[3])){
			return "redirect:/motorhomes/";
		} else {
			return "redirect:/login/";
		}

	}
}