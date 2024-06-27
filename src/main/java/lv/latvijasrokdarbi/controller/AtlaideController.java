package lv.latvijasrokdarbi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import lv.latvijasrokdarbi.model.Atlaide;
import lv.latvijasrokdarbi.service.IAtlaideService;

@Controller
@RequestMapping("/atlaide")
public class AtlaideController {
	
	@Autowired
	private IAtlaideService atlaideService;
	
	@GetMapping("/all") // localhost:8080/atlaide/all
	public String getAtlaideAll(Model model) {
		
		try {
			model.addAttribute("mydata", atlaideService.selectAllAtlaides());
			return "atlaide-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("all/{id}") // localhost:8080/atlaide/all/1
	public String getAtlaide(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", atlaideService.retrieveAtlaideById(id));
			model.addAttribute("msg", "Atlaide "+id);
			return "atlaide-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("/add") // localhost:8080/atlaide/add
	public String getAtlaideAdd(Model model) {
		model.addAttribute("atlaide", new Atlaide());
		return "atlaide-add-page";
		
	}
	
	@PostMapping("/add") // localhost:8080/atlaide/add
	public String postAtlaideAdd(@Valid Atlaide atlaide, BindingResult result) {
		if(result.hasErrors()) return "prece-add-page";
		else {
			atlaideService.createAtlaide(atlaide);
			return "redirect:/atlaide/all";	
		}
		
	}
//	
//	@GetMapping("/update/{id}") // localhost:8080/atlaide/update/1
//	public String getPreceUpdateById(@PathVariable("id") int id, Model model) {
//		try {
//			Prece toUpdate = preceService.retrievePreceById(id);
//			model.addAttribute("prece", toUpdate);
//			model.addAttribute("id", id);
//			return "prece-update-page";
//		}
//		catch (Exception e) {
//			model.addAttribute("mydata",e.getMessage());
//			return "error-page";
//		}
//	}
}
