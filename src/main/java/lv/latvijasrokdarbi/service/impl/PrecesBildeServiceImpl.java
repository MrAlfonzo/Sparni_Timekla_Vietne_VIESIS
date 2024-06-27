package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.PrecesBilde;
import lv.latvijasrokdarbi.repo.IPrecesBildeRepo;
import lv.latvijasrokdarbi.service.IPrecesBildeService;

@Service
public class PrecesBildeServiceImpl implements IPrecesBildeService{

	@Autowired
	private IPrecesBildeRepo precesBildeRepo;
	
	@Override
	public void createPrecesBilde(PrecesBilde precesBilde) {
		PrecesBilde existingPrecesBilde = precesBildeRepo.findByPreceAndBildeAndApraksts(precesBilde.getPrece(), precesBilde.getBilde(), precesBilde.getApraksts());
		if(existingPrecesBilde==null) precesBildeRepo.save(precesBilde);
		
	}

	@Override
	public PrecesBilde retrievePrecesBildeById(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if (precesBildeRepo.existsById(id)) return precesBildeRepo.findById(id).get();
		else throw new Exception("Nav kategorija ar id: "+id);
	}

	@Override
	public void updatePrecesBildeById(int id, PrecesBilde precesBilde) throws Exception {
		PrecesBilde toUpdate = retrievePrecesBildeById(id);

		toUpdate.setPrece(precesBilde.getPrece());
		toUpdate.setBilde(precesBilde.getBilde());
		toUpdate.setApraksts(precesBilde.getApraksts());
		
		precesBildeRepo.save(toUpdate);
	}

	@Override
	public void deletePrecesBildeById(int id) throws Exception {
		precesBildeRepo.delete(retrievePrecesBildeById(id));
		
	}

	@Override
	public void deletePrecesBildesByPreceId(int id) throws Exception {
		for(PrecesBilde tempB : selectAllPrecesBildesByPreceId(id)) {
			precesBildeRepo.delete(tempB);
		}
		
	}

	@Override
	public ArrayList<PrecesBilde> selectAllPrecesBildes() throws Exception {
		if(precesBildeRepo.count()==0) throw new Exception("precesBildeRepo ir tukša");
		return (ArrayList<PrecesBilde>) precesBildeRepo.findAll();
	}

	@Override
	public ArrayList<PrecesBilde> selectAllPrecesBildesByPreceId(int id) throws Exception {
		if(precesBildeRepo.count()==0) throw new Exception("precesBildeRepo ir tukša");
		return (ArrayList<PrecesBilde>) precesBildeRepo.findByPrece_PreceId(id);
	}

}
