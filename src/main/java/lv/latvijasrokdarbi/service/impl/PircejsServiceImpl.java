package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Pircejs;
import lv.latvijasrokdarbi.repo.IPircejsRepo;
import lv.latvijasrokdarbi.service.IPircejsService;

@Service
public class PircejsServiceImpl implements IPircejsService{

	@Autowired
	private IPircejsRepo pircejsRepo;
	
	
	@Override
	public void createPircejs(Pircejs pircejs) throws Exception {
		Pircejs existingPircejs = pircejsRepo.findByEpastsIgnoreCaseContaining(pircejs.getEpasts());
		if(existingPircejs!=null) throw new Exception("Pircējs ar šādu epastu jau eksistē");
		else pircejsRepo.save(pircejs);
	}
	
	@Override
	public Pircejs retrievePircejsById(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if (pircejsRepo.existsById(id)) return pircejsRepo.findById(id).get();
		else throw new Exception("Nav pircēja ar id: "+id);
	}

	@Override
	public void updatePircejsById(int id, Pircejs pircejs) throws Exception {
		Pircejs pircejsToUpdate = retrievePircejsById(id);
		
		pircejsToUpdate.setVards(pircejs.getVards());
		pircejsToUpdate.setUzvards(pircejs.getUzvards());
		pircejsToUpdate.setEpasts(pircejs.getEpasts());
		pircejsToUpdate.setAdrese(pircejs.getAdrese());
		pircejsToUpdate.setBankasNosaukums(pircejs.getBankasNosaukums());
		pircejsToUpdate.setBankasSwiftKods(pircejs.getBankasSwiftKods());
		pircejsToUpdate.setBankasKonts(pircejs.getBankasKonts());
		
		pircejsRepo.save(pircejsToUpdate);
		
	}
	
	@Override
	public void deletePircejsById(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if (pircejsRepo.existsById(id)) pircejsRepo.deleteById(id);
		else throw new Exception("Nav pircēja ar id: "+id);
	}
	
	@Override
	public ArrayList<Pircejs> selectAllPircejs() throws Exception {
		if(pircejsRepo.count()==0) throw new Exception("Nav ko atgriezt");
		return (ArrayList<Pircejs>) pircejsRepo.findAll();
	}
}
