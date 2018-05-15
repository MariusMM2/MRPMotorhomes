package com.mrp.motorhomes.controller;

import com.mrp.motorhomes.form.MotorhomeForm;
import com.mrp.motorhomes.model.Motorhome;
import com.mrp.motorhomes.repositories.CrudRepository;
import com.mrp.motorhomes.repositories.MotorhomeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.mrp.motorhomes.controller.MainController.currentUser;

@Controller
public class MotorhomeController {
	private CrudRepository<Motorhome> repository;
	
	public MotorhomeController() {
		repository = MotorhomeRepository.getInstance();
	}

	@GetMapping("/motorhomes")
	public String index(Model model) {
		model.addAttribute("motorhomes", repository.readAll());
		model.addAttribute("currentUser", currentUser);
		return "motorhomes/index";
	}

	@GetMapping("/motorhomes/create")
	public String create(Model model) {
		MotorhomeForm motorhomeForm = new MotorhomeForm();
		model.addAttribute("motorhomeForm", motorhomeForm);
		model.addAttribute("types", Motorhome.TYPES);
		return "motorhomes/create";
	}

	@PostMapping("/motorhomes/create")
	public String create(Model model, @ModelAttribute("motorhomeForm") MotorhomeForm motorhomeForm) {
		System.out.println(motorhomeForm);
		
		if(!motorhomeForm.validate()){
			model.addAttribute("errorMessage", MainController.ERROR_MESSAGE + " " + MainController.ERROR_MOTORHOME);
			model.addAttribute("types", Motorhome.TYPES);
			return "motorhomes/create";
		}
		else {
			Motorhome motorhome = motorhomeForm.toMotorhome();
			
			repository.create(motorhome);
			return "redirect:/motorhomes/";
		}
	}

	@GetMapping("/motorhomes/details")
	public String details(@RequestParam("id") int id, Model model) {
		Motorhome motorhome = repository.read(id);
		model.addAttribute("motorhome", motorhome);
		model.addAttribute("currentUser", currentUser);
		return "motorhomes/details";
	}

	@GetMapping("/motorhomes/clean")
	public String clean(@RequestParam("id") int id) {
		Motorhome motorhome = repository.read(id);
		if (motorhome.isCleaned() == true) {
			motorhome.setCleaned(false);
		} else {
			motorhome.setCleaned(true);
		}
		repository.update(motorhome);
		return "redirect:/motorhomes/";
	}

	@GetMapping("/motorhomes/service")
	public String service(@RequestParam("id") int id) {
		Motorhome motorhome = repository.read(id);
		if (motorhome.isServiced() == true) {
			motorhome.setServiced(false);
		} else {
			motorhome.setServiced(true);
		}
		repository.update(motorhome);
		return "redirect:/motorhomes/";
	}

	@PostMapping("/motorhomes/update")
	public String update(@ModelAttribute Motorhome motorhome) {
        repository.update(motorhome);
	    return "redirect:/motorhomes/";
	}


	@GetMapping("/motorhomes/delete")
	public String delete(@ModelAttribute Motorhome motorhome) {
        repository.delete(motorhome.getId());
        return "redirect:/motorhomes/";
	}

}