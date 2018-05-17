package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.form.RentalForm;
import com.mrp.motorhomes.model.Accessory;
import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.model.Rental;
import com.mrp.motorhomes.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static com.mrp.motorhomes.controller.MainController.currentUser;

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
		RentalForm rentalForm = new RentalForm();
		model.addAttribute("rentalForm", rentalForm);
		prepareForm(model);
		return "rentals/create";
	}
	
	@PostMapping("/rentals/create")
	public String create(Model model, @ModelAttribute("rentalForm") RentalForm rentalForm) {
		System.out.println(rentalForm);
		System.out.println(Arrays.toString(rentalForm.getAccessories()));
		if(!rentalForm.validate()){
			model.addAttribute("errorMessage", MainController.ERROR_MESSAGE + " " + MainController.ERROR_RENTAL);
			prepareForm(model);
			return "rentals/create";
		}
		else{
			Rental rental = rentalForm.toRental();
			
			rentalCrudRepository.create(rental);
			ArrayList<Rental> rentals = rentalCrudRepository.readAll();
			boolean found = false;
			for(Rental bRental : rentals) {
				if(bRental.equals(rental)){
					rental.setId(bRental.getId());
					found = true;
					break;
				}
			}
			
			if(found){
				for(Accessory accessory :
						rental.getAccessories()) {
					accessory.setRentalId(rental.getId());
				}
			}
			else{
				model.addAttribute("errorMessage", MainController.ERROR_MESSAGE);
				prepareForm(model);
				return "rentals/create";
			}
			
			Motorhome motorhome = motorhomeCrudRepository.read(rental.getMotorhomeId());
			motorhome.setCleaned(false);
			motorhome.setServiced(false);
			motorhomeCrudRepository.update(motorhome);
			
			AccessoryRepository.getInstance().create(rental.getAccessories());
			
			return "redirect:/rentals/";
		}
		
	}
	
	@GetMapping("/rentals/details")
	public String details(@RequestParam("id") int id, Model model) {
		Rental rental = rentalCrudRepository.read(id);
		System.out.println("details - rental " + rental);
		model.addAttribute("rental", rental);
		model.addAttribute("currentUser", currentUser);
		return "rentals/details";
	}

	@GetMapping("/rentals/pay")
	public String pay(@RequestParam("id") int id) {
		Rental rental = rentalCrudRepository.read(id);
		if (rental.isPaid()) {
			rental.setPaid(false);
		} else {
			rental.setPaid(true);
		}
		rentalCrudRepository.update(rental);
		return "redirect:/rentals/";
	}
	
	@GetMapping("/rentals/history")
	public String history(Model model) {
		model.addAttribute("rentals", rentalCrudRepository.readAll());
		model.addAttribute("readsAll", true);
		return "rentals/index";
	}
	
	
	@GetMapping("/rentals")
	public String index(Model model) {
		model.addAttribute("rentals", getActiveRentals());
		model.addAttribute("currentUser", currentUser);
		return "rentals/index";
	}
	
	
	@PostMapping("/rentals/details/update")
	public String update(@ModelAttribute Rental rental) {
		rental.setPaid(true);
		rentalCrudRepository.update(rental);
		return "redirect:/rentals/details/";
	}
	
	@GetMapping("/rentals/delete")
	public String delete(@RequestParam("id") int id) {
		rentalCrudRepository.delete(id);
		return "redirect:/rentals/";
	}
	
	private ArrayList<Rental> getActiveRentals(){
		ArrayList<Rental> rentals = rentalCrudRepository.readAll();
		for(int i = 0; i < rentals.size();) {
			if(rentals.get(i).isEnded()) {
				rentals.remove(i);
			}
			else{
				i++;
			}
		}
		
		return rentals;
	}
	
	private ArrayList<Motorhome> getAvailableMotorhomes(){
		ArrayList<Rental> rentals = getActiveRentals();
		ArrayList<Motorhome> motorhomes = motorhomeCrudRepository.readAll();
		for(int i = 0; i < rentals.size(); i++) {
			for(int j = 0; j < motorhomes.size(); j++) {
				if(motorhomes.get(j).getId() == rentals.get(i).getMotorhomeId()){
					motorhomes.remove(j);
					break;
				}
			}
		}
		return motorhomes;
	}
	
	private void prepareForm(Model model){
		model.addAttribute("customers", CustomerRepository.getInstance().readAll());
		model.addAttribute("motorhomes",getAvailableMotorhomes());
		model.addAttribute("allAccessories", Accessory.ALL_ACCESSORIES);
		model.addAttribute("minStartDate", LocalDate.now().plusWeeks(1));
		model.addAttribute("minEndDate", LocalDate.now().plusWeeks(1).plusDays(1));
	}
}