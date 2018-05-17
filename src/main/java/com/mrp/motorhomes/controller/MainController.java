package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	static final String ERROR_MESSAGE = "All fields are required." ;
	static final String ERROR_CUSTOMER = "Email must have an @ and end with .com or .dk. Phone and SSN must " +
			"contain only digits. Names must contain at least 3 letters.";
	static final String ERROR_MOTORHOME = "";
	static final String ERROR_RENTAL   = "Start date cannot be before today's " +
			"date. End date cannot be before start date.";
    
    static User currentUser = User.ALL_USERS[0];
	
	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("users", User.ALL_USERS);
		return "login";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("name") String name){
		for(User user : User.ALL_USERS) {
			if(user.getName().equals(name)){
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