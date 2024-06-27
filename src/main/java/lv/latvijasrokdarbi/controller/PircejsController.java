package lv.latvijasrokdarbi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.latvijasrokdarbi.model.Pircejs;
import lv.latvijasrokdarbi.service.IPircejsService;

@Controller
@RequestMapping("/pircejs")
public class PircejsController {
	
	@Autowired
	private IPircejsService pircejsService;
	
	@GetMapping("/all") // localhost:8080/pircejs/all
	public String getPircejsAll(Model model) {
		
		try {
			model.addAttribute("mydata", pircejsService.selectAllPircejs());
			return "pircejs-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("all/{id}") // localhost:8080/pircejs/all/1
	public String getPircejs(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", pircejsService.retrievePircejsById(id));
			model.addAttribute("msg", "Prece "+id);
			return "pircejs-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/add")
	public String getAddPircejs(Model model) {
		model.addAttribute("pircejs", new Pircejs());
		return "pircejs-add-page";
	}
	
	@PostMapping("/add")
	public String postAddPircejs(@Valid Pircejs pircejs, BindingResult result) {
		if(result.hasErrors()) {
			return "pircejs-add-page";
		}
		else {
			try {
				pircejsService.createPircejs(pircejs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/pircejs/all";
		}
	}
	
	@GetMapping("/update/{id}")
	public String getUpdatePircejs(@PathVariable("id") int id, Model model) {
		try {
			Pircejs pircejsToUpdate = pircejsService.retrievePircejsById(id);
			model.addAttribute("pircejs", pircejsToUpdate);
			model.addAttribute("id", id);
			return "pircejs-update-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}
	
	@PostMapping("/update/{id}")
	public String postUpdatePircejs(@PathVariable("id") int id, @Valid Pircejs pircejs, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "pircejs-update-page";
		}
		else {
			try {
				pircejsService.updatePircejsById(id, pircejs);
				return "redirect:/pircejs/all/" + id;
			} catch (Exception e) {
				model.addAttribute("mydata", e.getMessage());
				return "error-page";
			}
		}
	}
	
	@GetMapping("/delete/{id}")
	public String getDeletePircejs(@PathVariable("id") int id, Model model) {
		try {
			//Jāizdzēš sūtījumiem pircēji?, lai nebūtu FK error
			pircejsService.deletePircejsById(id);
			ArrayList<Pircejs> allPircejs = (ArrayList<Pircejs>) pircejsService.selectAllPircejs();
			model.addAttribute("mydata", allPircejs);
			return "pircejs-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}
