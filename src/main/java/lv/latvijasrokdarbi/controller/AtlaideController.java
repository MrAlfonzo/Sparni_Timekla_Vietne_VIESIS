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
	
	@GetMapping("/update/{id}") // localhost:8080/atlaide/update/1
	public String getAtlaideUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Atlaide toUpdate = atlaideService.retrieveAtlaideById(id);
			model.addAttribute("atlaide", toUpdate);
			model.addAttribute("id", id);
			return "atlaide-update-page";
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	@PostMapping("/update/{id}")
	public String postAtlaideUpdateById(@PathVariable("id") int id, 
			@Valid Atlaide atlaide, BindingResult result, Model model) {
		try {
			atlaideService.updateAtlaideById(id, atlaide);
			return "redirect:/atlaide/all/"+id;
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/delete/{id}") // localhost:8080/atlaide/delete/1
	public String getAtlaideDelete(@PathVariable("id") int id, Model model) {
		try {
			atlaideService.deleteAtlaideById(id);
			ArrayList<Atlaide> allAtlaides = atlaideService.selectAllAtlaides();
			model.addAttribute("mydata", allAtlaides);
			return "atlaide-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("meklet/{param}") // localhost:8080/atlaide/meklet/{param}
	public String getAtlaideFilterByNosaukumsOrApraksts(@PathVariable("param") String param, Model model) {
		
		try {
			ArrayList<Atlaide> result = atlaideService.filterByNosaukumsOrApraksts(param);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "Rezultāti frāzei '"+param+"'");
			return "atlaide-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
}
