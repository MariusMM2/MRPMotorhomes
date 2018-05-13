package com.mrp.motorhomes.controller;

import java.util.*;

import com.mrp.motorhomes.model.Accessory;
import com.mrp.motorhomes.model.Rental;
import com.mrp.motorhomes.model.RentalView;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.CustomerRepository;
import com.mrp.motorhomes.repositories.MotorhomeRepository;
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
		repository = RentalRepository.getInstance();
	}



	@GetMapping("/rentals")
	public String index(Model model) {
		ArrayList<Rental> rentals = repository.readAll();
		
		model.addAttribute("r", rentals);
		return "rentals/index";
	}

	@GetMapping("/rentals/details")
	public String details(@RequestParam("id") int id, Model model) {
		Rental rental = repository.read(id);
		System.out.println(rental);
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
	public String create(Model model){
		model.addAttribute("customers", CustomerRepository.getInstance().readAll());
		model.addAttribute("motorhomes", MotorhomeRepository.getInstance().readAll());
		model.addAttribute("accessories", Accessory.ALL_ACCESSORIES);
		return "rentals/create";
	}

	@PostMapping("/rentals/create")
	public String create(@ModelAttribute Rental rental){
		System.out.println(rental);
		repository.create(rental);
		return "redirect:/rentals/";
	}



	@PostMapping("/rentals/update")
	public String update(@ModelAttribute Rental rental) {
		repository.update(rental);
		return "redirect:/rentals/";
	}

	@GetMapping("/rentals/delete")
	public String delete(@ModelAttribute Rental rental) {
		repository.delete(rental.getId());
		return "redirect:/rentals/";
	}

}