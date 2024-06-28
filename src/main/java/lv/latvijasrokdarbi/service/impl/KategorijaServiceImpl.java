package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Kategorija;
import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.repo.IKategorijaRepo;
import lv.latvijasrokdarbi.repo.IPreceRepo;
import lv.latvijasrokdarbi.service.IKategorijaService;

@Service
public class KategorijaServiceImpl implements IKategorijaService{

	@Autowired
	private IKategorijaRepo kategorijaRepo;
	@Autowired
	private IPreceRepo preceRepo;
	
	@Override
	public void createKategorija(Kategorija kategorija) {
		Kategorija existingKategorija = kategorijaRepo.findByNosaukumsAndApraksts(kategorija.getNosaukums(), kategorija.getApraksts());
		if(existingKategorija==null) kategorijaRepo.save(kategorija);
	}

	@Override
	public Kategorija retrieveKategorijaById(int id) throws Exception {
		if (id < 0) throw new Exception("id jābūt pozitīvam");
		if (kategorijaRepo.existsById(id)) return kategorijaRepo.findById(id).get();
		else throw new Exception("Nav kategorija ar id: "+id);
	}

	@Override
	public void updateKategorijaById(int id, Kategorija kategorija) throws Exception {
		Kategorija toUpdate = retrieveKategorijaById(id);

		toUpdate.setNosaukums(kategorija.getNosaukums());
		toUpdate.setApraksts(kategorija.getApraksts());
		
		kategorijaRepo.save(toUpdate);
		
	}

	@Override
	public void deleteKategorijaById(int id) throws Exception {
		Collection<Prece> preces = retrieveKategorijaById(id).getPreces();
		if(!preces.isEmpty()) {
			for(Prece tempP : preces) {
				tempP.setKategorija(null);
				preceRepo.save(tempP);
			}
		}
		kategorijaRepo.delete(retrieveKategorijaById(id));
		
	}

	@Override
	public ArrayList<Kategorija> selectAllKategorijas() throws Exception {
		if(kategorijaRepo.count()==0) throw new Exception("kategorijaRepo ir tukša");
		return (ArrayList<Kategorija>) kategorijaRepo.findAll();
	}

	@Override
	public ArrayList<Kategorija> filterByNosaukumsOrApraksts(String phrase) throws Exception {
		if(phrase==null) throw new Exception("frāze ir null");
		if(kategorijaRepo.count()==0) throw new Exception("kategorijaRepo ir tukša");
		ArrayList<Kategorija> filteredKategorija = kategorijaRepo.findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(phrase, phrase);
		return filteredKategorija;
	}

}
