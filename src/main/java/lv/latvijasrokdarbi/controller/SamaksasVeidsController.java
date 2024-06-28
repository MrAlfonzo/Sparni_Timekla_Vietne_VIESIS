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
import lv.latvijasrokdarbi.model.SamaksasVeids;
import lv.latvijasrokdarbi.service.ISamaksasVeidsService;

@Controller
@RequestMapping("/samaksasveids")
public class SamaksasVeidsController {
	
	@Autowired
	private ISamaksasVeidsService samaksasVeidsService;
	
	@GetMapping("/all") // localhost:8080/samaksasveids/all
	public String getSamaksasVeidsAll(Model model) {
		
		try {
			model.addAttribute("mydata", samaksasVeidsService.selectAllSamaksasVeids());
			return "samaksasVeids-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("all/{id}") // localhost:8080/samaksasveids/all/1
	public String getSamaksasVeids(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", samaksasVeidsService.retrieveSamaksasVeidsById(id));
			model.addAttribute("msg", "Prece "+id);
			return "samaksasVeids-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/add")
	public String getAddSamaksasVeids(Model model) {
		model.addAttribute("samaksasVeids", new SamaksasVeids());
		return "samaksasVeids-add-page";
	}
	
	@PostMapping("/add")
	public String postAddSamaksasVeids(@Valid SamaksasVeids samaksasVeids, BindingResult result) {
		if(result.hasErrors()) {
			return "pircejs-add-page";
		}
		else {
			try {
				samaksasVeidsService.createSamaksasVeids(samaksasVeids);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "redirect:/samaksasveids/all";
		}
	}
	
	@GetMapping("/update/{id}")
	public String getUpdateSamaksasVeids(@PathVariable("id") int id, Model model) {
		try {
			SamaksasVeids samaksasVeidsToUpdate = samaksasVeidsService.retrieveSamaksasVeidsById(id);
			model.addAttribute("samaksasVeids", samaksasVeidsToUpdate);
			model.addAttribute("id", id);
			return "samaksasveids-update-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}

	}
	
	@PostMapping("/update/{id}")
	public String postUpdateSamaksasVeids(@PathVariable("id") int id, @Valid SamaksasVeids samaksasVeids, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "samaksasVeids-update-page";
		}
		else {
			try {
				samaksasVeidsService.updateSamaksasVeidsById(id, samaksasVeids);
				return "redirect:/samaksasveids/all/" + id;
			} catch (Exception e) {
				model.addAttribute("mydata", e.getMessage());
				return "error-page";
			}
		}
	}
	
	@GetMapping("/delete/{id}")
	public String getDeleteSamaksasVeids(@PathVariable("id") int id, Model model) {
		try {
			//Jāizdzēš pirkumiem veidi?, lai nebūtu FK error
			samaksasVeidsService.deleteSamaksasVeidsById(id);
			ArrayList<SamaksasVeids> allSamaksasVeids = (ArrayList<SamaksasVeids>) samaksasVeidsService.selectAllSamaksasVeids();
			model.addAttribute("mydata", allSamaksasVeids);
			return "samaksasVeids-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}
}
