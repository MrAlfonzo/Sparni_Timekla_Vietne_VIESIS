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
import lv.latvijasrokdarbi.model.Kategorija;
import lv.latvijasrokdarbi.service.IKategorijaService;

@Controller
@RequestMapping("/kategorija")
public class KategorijaController {
	@Autowired
	private IKategorijaService kategorijaService;
	
	@GetMapping("/all") // localhost:8080/kategorija/all
	public String getKategorijaAll(Model model) {
		
		try {
			model.addAttribute("mydata", kategorijaService.selectAllKategorijas());
			return "kategorija-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("all/{id}") // localhost:8080/kategorija/all/1
	public String getKategorija(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", kategorijaService.retrieveKategorijaById(id));
			model.addAttribute("msg", "Kategorija "+id);
			return "kategorija-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	@GetMapping("/add") // localhost:8080/kategorija/add
	public String getKategorijaAdd(Model model) {
		model.addAttribute("kategorija", new Kategorija());
		return "kategorija-add-page";
		
	}
	
	@PostMapping("/add") // localhost:8080/atlaide/add
	public String postKategorijaAdd(@Valid Kategorija kategorija, BindingResult result) {
		if(result.hasErrors()) return "kategorija-add-page";
		else {
			kategorijaService.createKategorija(kategorija);
			return "redirect:/kategorija/all";	
		}
		
	}
	
	@GetMapping("/update/{id}") // localhost:8080/kategorija/update/1
	public String getKategorijaUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Kategorija toUpdate = kategorijaService.retrieveKategorijaById(id);
			model.addAttribute("kategorija", toUpdate);
			model.addAttribute("id", id);
			return "kategorija-update-page";
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	@PostMapping("/update/{id}")
	public String postKategorijaUpdateById(@PathVariable("id") int id, 
			@Valid Kategorija kategorija, BindingResult result, Model model) {
		try {
			kategorijaService.updateKategorijaById(id, kategorija);
			return "redirect:/kategorija/all/"+id;
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/delete/{id}") // localhost:8080/kategorija/delete/1
	public String getKategorijaDelete(@PathVariable("id") int id, Model model) {
		try {
			kategorijaService.deleteKategorijaById(id);
			ArrayList<Kategorija> allKategorijas = kategorijaService.selectAllKategorijas();
			model.addAttribute("mydata", allKategorijas);
			return "kategorija-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("meklet/{param}") // localhost:8080/kategorija/meklet/{param}
	public String getKategorijaFilterByNosaukumsOrApraksts(@PathVariable("param") String param, Model model) {
		
		try {
			ArrayList<Kategorija> result = kategorijaService.filterByNosaukumsOrApraksts(param);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "Rezultāti frāzei '"+param+"'");
			return "kategorija-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
}
