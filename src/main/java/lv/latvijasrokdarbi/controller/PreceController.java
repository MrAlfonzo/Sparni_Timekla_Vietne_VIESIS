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
import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.service.IPreceService;

@Controller
@RequestMapping("/prece")
public class PreceController {
	@Autowired
	private IPreceService preceService;
	
	@GetMapping("/all") // localhost:8080/prece/all
	public String getPreceAll(Model model) {
		
		try {
			model.addAttribute("mydata", preceService.selectAllPreces());
			return "prece-all-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("all/{id}") // localhost:8080/prece/all/1
	public String getPrece(@PathVariable("id") int id, Model model) {
		
		try {
			model.addAttribute("mydata", preceService.retrievePreceById(id));
			model.addAttribute("msg", "Prece "+id);
			return "prece-one-page";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("/add") // localhost:8080/prece/add
	public String getPreceAdd(Model model) {
		model.addAttribute("prece", new Prece());
		return "prece-add-page";
		
	}
	
	@PostMapping("/add") // localhost:8080/prece/add
	public String postPreceAdd(@Valid Prece prece, BindingResult result) {
		if(result.hasErrors()) {
			return "prece-add-page";
		}
		else {
			preceService.createPrece(prece);
			return "redirect:/prece/all";	
		}
		
	}
	
	@GetMapping("/update/{id}") // localhost:8080/prece/update/1
	public String getPreceUpdateById(@PathVariable("id") int id, Model model) {
		try {
			Prece toUpdate = preceService.retrievePreceById(id);
			model.addAttribute("prece", toUpdate);
			model.addAttribute("id", id);
			return "prece-update-page";
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@PostMapping("/update/{id}")
	public String postPreceUpdateById(@PathVariable("id") int id, 
			@Valid Prece prece, BindingResult result, Model model) {
		try {
			preceService.updatePreceById(id, prece);
			return "redirect:/prece/all/"+id; //parlec uz /prece/all/{id}
		}
		catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/delete/{id}") // localhost:8080/prece/delete/1
	public String getPreceDelete(@PathVariable("id") int id, Model model) {
		try {
			preceService.deletePreceById(id);
			ArrayList<Prece> allPreces = preceService.selectAllPreces();
			model.addAttribute("mydata", allPreces);
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata",e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("atlaide/{id}") // localhost:8080/prece/atlaide/1
	public String getPreceByAtlaideId(@PathVariable("id") int id, Model model) {
		
		try {
			ArrayList<Prece> result = preceService.selectAllPrecesByAtlaideId(id);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "preces ar atlaideId: "+id);
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}	
	
	@GetMapping("kategorija/{id}") // localhost:8080/prece/kategorija/1
	public String getPreceByKategorijaId(@PathVariable("id") int id, Model model) {
		
		try {
			ArrayList<Prece> result = preceService.selectAllPrecesByKategorijaId(id);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "preces ar kategorijaId: "+id);
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
	}	
	
	@GetMapping("cena/{param}") // localhost:8080/prece/cena/2
	public String getPreceFilterByCena(@PathVariable("param") float param, Model model) {
		
		try {
			ArrayList<Prece> result = preceService.selectAllPrecesCenaLessThan(param);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "preces ar cenu vienādu vai zemāku par "+param);
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("daudzums/{param}") // localhost:8080/prece/daudzums/2
	public String getPreceFilterByDaudzums(@PathVariable("param") int param, Model model) {
		
		try {
			ArrayList<Prece> result = preceService.filterByDaudzums(param);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "preces ar daudzumu vienādu vai zemāku par "+param);
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
	
	@GetMapping("meklet/{param}") // localhost:8080/prece/meklet/{param}
	public String getPreceFilterByNosaukumsOrApraksts(@PathVariable("param") String param, Model model) {
		
		try {
			ArrayList<Prece> result = preceService.filterByNosaukumsOrApraksts(param);
			model.addAttribute("mydata", result);
			model.addAttribute("msg", "Rezultāti frāzei '"+param+"'");
			return "prece-all-page";
		} catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());
			return "error-page";
		}
		
	}
	
}
