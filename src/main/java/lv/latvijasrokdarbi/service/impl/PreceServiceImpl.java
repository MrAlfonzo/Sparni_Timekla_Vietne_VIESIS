package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.repo.IPreceRepo;
import lv.latvijasrokdarbi.service.IPreceService;

@Service
public class PreceServiceImpl implements IPreceService{
	
	@Autowired
	private IPreceRepo preceRepo;
	
	@Override
	public void createPrece(Prece prece) {
		Prece existingPrece = preceRepo.findByNosaukumsAndAprakstsAndCena(prece.getNosaukums(), prece.getApraksts(), prece.getCena());
		if(existingPrece!=null) {
			existingPrece.setDaudzums(existingPrece.getDaudzums()+prece.getDaudzums());
			preceRepo.save(existingPrece);
			return;
		}
		preceRepo.save(prece);
	}

	@Override
	public Prece retrievePreceById(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if (preceRepo.existsById(id)) return preceRepo.findById(id).get();
		else throw new Exception("Nav prece ar id: "+id);
	}

	@Override
	public void updatePreceById(int id, Prece prece) throws Exception {
		Prece toUpdate = retrievePreceById(id);
		
		toUpdate.setKategorija(prece.getKategorija());
		toUpdate.setNosaukums(prece.getNosaukums());
		toUpdate.setApraksts(prece.getApraksts());
		toUpdate.setCena(prece.getCena());
		toUpdate.setDaudzums(prece.getDaudzums());
		toUpdate.setAtlaide(prece.getAtlaide());
		
		preceRepo.save(toUpdate);
	}

	@Override
	public void deletePreceById(int id) throws Exception {
		preceRepo.delete(retrievePreceById(id));
		
	}

	@Override
	public ArrayList<Prece> selectAllPreces() throws Exception {
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		return (ArrayList<Prece>) preceRepo.findAll();
	}

	@Override
	public ArrayList<Prece> selectAllPrecesByAtlaideId(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		return (ArrayList<Prece>) preceRepo.findByAtlaide_AtlaideId(id);
	}

	@Override
	public ArrayList<Prece> selectAllPrecesByKategorijaId(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		return (ArrayList<Prece>) preceRepo.findByKategorija_KategorijaId(id);
	}

	@Override
	public ArrayList<Prece> selectAllPrecesCenaLessThan(float cena) throws Exception {
		if(cena<=0) throw new Exception("Cena nevar būt 0 vai zemāka");
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		ArrayList<Prece> filteredPreces = preceRepo.findByCenaLessThanEqual(cena);
		return filteredPreces;
	}

	@Override
	public ArrayList<Prece> filterByDaudzums(int daudzums) throws Exception {
		if(daudzums<=0) throw new Exception("Daudzums nevar būt 0 vai zemāks");
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		ArrayList<Prece> filteredPreces = preceRepo.findByDaudzumsLessThanEqual(daudzums);
		return filteredPreces;
	}

	@Override
	public ArrayList<Prece> filterByNosaukumsOrApraksts(String phrase) throws Exception {
		if(phrase==null) throw new Exception("frāze ir null");
		if(preceRepo.count()==0) throw new Exception("preceRepo ir tukša");
		ArrayList<Prece> filteredPrece = preceRepo.findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(phrase, phrase);
		return filteredPrece;
	}

}
