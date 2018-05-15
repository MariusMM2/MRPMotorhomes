package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.form.CustomerForm;
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
		repository = CustomerRepository.getInstance();
	}

	@GetMapping("/customers")
	public String index(Model model){
		model.addAttribute("customers", repository.readAll());
		return "customers/index";
	}

	@GetMapping("/customers/create")
	public String create(Model model){
		CustomerForm customerForm = new CustomerForm();
		model.addAttribute("customerForm", customerForm);
		return "customers/create";
	}
	
	@PostMapping("/customers/create")
	public String create(Model model, @ModelAttribute("customerForm") CustomerForm customerForm){
		System.out.println(customerForm);
		
		if(!customerForm.validate()){
			model.addAttribute("errorMessage", MainController.ERROR_MESSAGE + " " + MainController.ERROR_CUSTOMER);
			return "customers/create";
		}
		else
		{
			Customer customer = customerForm.toCustomer();
			
			repository.create(customer);
			return "redirect:/customers/";
		}
	}
	
	@GetMapping("/customers/details")
	public String details(@RequestParam("id") int id, Model model){
		model.addAttribute("customer", repository.read(id));
		return "customers/details";
	}
	
	@GetMapping("/customers/delete")
	public String delete(@RequestParam("id") int id){
		repository.delete(id);
		return "redirect:/customers/";
	}
}