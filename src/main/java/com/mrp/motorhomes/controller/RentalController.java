package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.model.Accessory;
import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.model.Rental;
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
	private CrudRepository<Rental> rentalCrudRepository;
	private CrudRepository<Motorhome> motorhomeCrudRepository;
	
	public RentalController() {
		rentalCrudRepository = RentalRepository.getInstance();
		motorhomeCrudRepository = MotorhomeRepository.getInstance();
	}
	
	@GetMapping("/rentals/create")
	public String create(Model model) {
		model.addAttribute("customers", CustomerRepository.getInstance().readAll());
		model.addAttribute("motorhomes", motorhomeCrudRepository.readAll());
		model.addAttribute("accessories", Accessory.ALL_ACCESSORIES);
		return "rentals/create";
	}
	
	@PostMapping("/rentals/create")
	public String create(@ModelAttribute Rental rental) {
		System.out.println(rental);
		Motorhome motorhome = motorhomeCrudRepository.read(rental.getId());
		motorhome.setCleaned(false);
		motorhome.setServiced(false);
		motorhomeCrudRepository.update(motorhome);
		rentalCrudRepository.create(rental);
		return "redirect:/rentals/";
	}
	
	@GetMapping("/rentals/details")
	public String details(@RequestParam("id") int id, Model model) {
		Rental rental = rentalCrudRepository.read(id);
		System.out.println(rental);
		model.addAttribute("rental", rental);
		return "rentals/details";
	}
	
	@GetMapping("/rentals/history")
	public String history(Model model) {
		model.addAttribute("r", rentalCrudRepository.readAll());
		return "rentals/index";
	}
	
	
	@GetMapping("/rentals")
	public String index(Model model) {
		ArrayList<Rental> rentals = rentalCrudRepository.readAll();
		for(int i = 0; i < rentals.size(); i++) {
			if(rentals.get(i).isEnded()) {
				rentals.remove(i);
			}
		}
		
		model.addAttribute("r", rentals);
		return "rentals/index";
	}
	
	
	@PostMapping("/rentals/update")
	public String update(@ModelAttribute Rental rental) {
		rentalCrudRepository.update(rental);
		return "redirect:/rentals/";
	}
	
	@GetMapping("/rentals/delete")
	public String delete(@RequestParam("id") int id) {
		rentalCrudRepository.delete(id);
		return "redirect:/rentals/";
	}
}