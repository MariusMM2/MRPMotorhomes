package com.mrp.motorhomes.controller;

import java.util.*;

import com.mrp.motorhomes.model.Customer;
import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.model.Rental;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.CustomerRepository;
import com.mrp.motorhomes.repositories.RentalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class RentalController {
	private CrudRepository<Rental> repository;

	public RentalController(){
		repository = new RentalRepository();
	}


	@GetMapping("/rentals")
	public String readAll(Model model) {
		ArrayList<Rental> rentals = repository.readAll();
		model.addAttribute("r", rentals);
		return "rentals/index";
	}

	@GetMapping("/rentals/details")
	public String details(@RequestParam("id") int id, Model model) {
		Rental rental = repository.read(id);
		model.addAttribute("rental", rental);
//		model.addAttribute("rental", rental);
		return "rentals/details";
	}


//	@GetMapping("/rentals")
//	public String index(Model model) {
//		model.addAttribute("rental", repository.readAll());
//		return "rentals/index";
//	}

	@GetMapping("/rentals/create")
	public String create(){
		return "rentals/create";
	}

	@PostMapping("/rentals/create")
	public String create(@ModelAttribute Rental rental){
		repository.create(rental);
		System.out.println(rental);
		return "rentals/";
	}



	@PostMapping("/rentals/update")
	public String update(@ModelAttribute Rental rental) {
		repository.update(rental);
		return "redirect:/rentals";
	}

	@PostMapping("/rentals/delete")
	public String delete(@ModelAttribute Rental rental) {
		repository.delete(rental.getId());
		return "redirect:/rentals";
	}


//




}