//package lv.latvijasrokdarbi.service.impl;
//
//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import lv.latvijasrokdarbi.model.Kategorija;
//import lv.latvijasrokdarbi.model.PrecesBilde;
//import lv.latvijasrokdarbi.repo.IPrecesBildeRepo;
//import lv.latvijasrokdarbi.service.IPrecesBildeService;
//
//@Service
//public class PrecesBildeServiceImpl implements IPrecesBildeService{
//
//	@Autowired
//	private IPrecesBildeRepo precesBildeRepo;
//	
//	@Override
//	public void createPrecesBilde(PrecesBilde precesBilde) {
//		PrecesBilde existingPrecesBilde = precesBildeRepo.findByPreceIdAndBildeAndApraksts(precesBilde.getPrece().getPreceId(), precesBilde.getBilde(), precesBilde.getApraksts());
//		if(existingPrecesBilde==null) precesBildeRepo.save(precesBilde);
//		
//	}
//
//	@Override
//	public PrecesBilde retrievePrecesBildeById(int id) throws Exception {
//		if (id < 0) throw new Exception("id jābūt pozitīvam");
//		if (kategorijaRepo.existsById(id)) return kategorijaRepo.findById(id).get();
//		else throw new Exception("Nav kategorija ar id: "+id);
//		return null;
//	}
//
//	@Override
//	public void updatePrecesBildeById(int id, PrecesBilde precesBilde) throws Exception {
//		Kategorija toUpdate = retrieveKategorijaById(id);
//
//		toUpdate.setNosaukums(kategorija.getNosaukums());
//		toUpdate.setApraksts(kategorija.getApraksts());
//		
//		kategorijaRepo.save(toUpdate);
//	}
//
//	@Override
//	public void deletePrecesBildeById(int id) throws Exception {
//		kategorijaRepo.delete(retrieveKategorijaById(id));
//		
//	}
//
//	@Override
//	public void deletePrecesBildesByPreceId(int id) throws Exception {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public ArrayList<PrecesBilde> selectAllPrecesBildes() throws Exception {
//		if(kategorijaRepo.count()==0) throw new Exception("kategorijaRepo ir tukša");
//		return (ArrayList<Kategorija>) kategorijaRepo.findAll();
//	}
//
//	@Override
//	public ArrayList<PrecesBilde> selectAllPrecesBildesByPrecesId(int id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
