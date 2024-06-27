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
import lv.latvijasrokdarbi.model.PrecesBilde;
import lv.latvijasrokdarbi.service.IPrecesBildeService;

@Controller
@RequestMapping("/precesbilde")
public class PrecesBildeController {
	@Autowired
	private IPrecesBildeService precesBildeService;
	
	@GetMapping("/all") // localhost:8080/precesbilde/all
	public String getPrecesBildeAll(Model model) {
		
		try {
			model.addAttribute("mydata", precesBildeService.selectAllPrecesBildes());
			return "precesbilde-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("all/{id}") // localhost:8080/precesbilde/all/1
	public String getPrecesBilde(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", precesBildeService.retrievePrecesBildeById(id));
			model.addAttribute("msg", "PrecesBilde "+id);
			return "precesbilde-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("/add") // localhost:8080/precesbilde/add
	public String getPrecesBildeAdd(Model model) {
		model.addAttribute("precesBilde", new PrecesBilde());
		return "precesbilde-add-page";
		
	}
	
	@PostMapping("/add") // localhost:8080/atlaide/add
	public String postPrecesBildeAdd(@Valid PrecesBilde precesBilde, BindingResult result) {
		if(result.hasErrors()) return "precesbilde-add-page";
		else {
			precesBildeService.createPrecesBilde(precesBilde);
			return "redirect:/precesbilde/all";	
		}
		
	}
	
	@GetMapping("/update/{id}") // localhost:8080/precesbilde/update/1
	public String getPrecesBildeUpdateById(@PathVariable("id") int id, Model model) {
		try {
			PrecesBilde toUpdate = precesBildeService.retrievePrecesBildeById(id);
			model.addAttribute("precesBilde", toUpdate);
			model.addAttribute("id", id);
			return "precesbilde-update-page";
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	@PostMapping("/update/{id}")
	public String postPrecesBildeUpdateById(@PathVariable("id") int id, 
			@Valid PrecesBilde precesBilde, BindingResult result, Model model) {
		try {
			precesBildeService.updatePrecesBildeById(id, precesBilde);
			return "redirect:/precesbilde/all/"+id;
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/delete/{id}") // localhost:8080/precesbilde/delete/1
	public String getPrecesBildeDelete(@PathVariable("id") int id, Model model) {
		try {
			precesBildeService.deletePrecesBildeById(id);
			ArrayList<PrecesBilde> allPrecesBildes = precesBildeService.selectAllPrecesBildes();
			model.addAttribute("mydata", allPrecesBildes);
			return "precesbilde-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/all/prece/{id}") // localhost:8080/precesbilde/all/prece/1
	public String getPrecesBildesByPreceId(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", precesBildeService.selectAllPrecesBildesByPreceId(id));
			model.addAttribute("msg", "Preces "+id+" bildes");
			return "precesbilde-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("/delete/prece/{id}") // localhost:8080/precesbilde/delete/prece/1
	public String getPrecesBildeDeleteByPreceId(@PathVariable("id") int id, Model model) {
		try {
			precesBildeService.deletePrecesBildesByPreceId(id);
			ArrayList<PrecesBilde> allPrecesBildes = precesBildeService.selectAllPrecesBildes();
			model.addAttribute("mydata", allPrecesBildes);
			return "precesbilde-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
	
}
