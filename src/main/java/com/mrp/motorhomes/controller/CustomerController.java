package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.Customer;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
	private CrudRepository<Customer> repository;
	
	public CustomerController(){
		repository = new CustomerRepository();
	}

	@GetMapping("/customers")
	public String index(Model model){
		model.addAttribute("customers", repository.readAll());
		return "customers/index";
	}

	@GetMapping("/customers/create")
	public String create(Model model){
		return "redirect:/customers";
	}
}