package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.Customer;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String create(){
		return "customers/create";
	}
	
	@PostMapping("/customers/create")
	public String create(@ModelAttribute Customer customer){
		repository.create(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/customers/details")
	public String details(@RequestParam("id") int id, Model model){
		model.addAttribute(repository.read(id));
		return "customers/details";
	}
}