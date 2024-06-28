package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.SamaksasVeids;
import lv.latvijasrokdarbi.repo.ISamaksasVeidsRepo;
import lv.latvijasrokdarbi.service.ISamaksasVeidsService;

@Service
public class SamaksasVeidsServiceImpl implements ISamaksasVeidsService {
	
	@Autowired
	private ISamaksasVeidsRepo samaksasVeidsRepo;

	@Override
	public void createSamaksasVeids(SamaksasVeids samaksasVeids) throws Exception {
		SamaksasVeids existingSamaksasVeids = samaksasVeidsRepo.findByNosaukumsIgnoreCaseContaining(samaksasVeids.getNosaukums());
		if(existingSamaksasVeids!=null) throw new Exception("Samaksas veids ar šādu nosaukumu jau eksistē");
		else samaksasVeidsRepo.save(samaksasVeids);
	}

	@Override
	public SamaksasVeids retrieveSamaksasVeidsById(int id) throws Exception {
		if (id < 0) throw new Exception("Id jābūt pozitīvam");
		if (samaksasVeidsRepo.existsById(id)) return samaksasVeidsRepo.findById(id).get();
		else throw new Exception("Nav samaksas veida ar id: "+id);
	}

	@Override
	public void updateSamaksasVeidsById(int id, SamaksasVeids samaksasVeids) throws Exception {
		SamaksasVeids samaksasVeidsToUpdate = retrieveSamaksasVeidsById(id);
		
		samaksasVeidsToUpdate.setNosaukums(samaksasVeids.getNosaukums());
		samaksasVeidsToUpdate.setPiezimes(samaksasVeids.getPiezimes());
		
		samaksasVeidsRepo.save(samaksasVeidsToUpdate);
	}

	@Override
	public void deleteSamaksasVeidsById(int id) throws Exception {
		if (id < 0) throw new Exception("Id jābūt pozitīvam");
		if (samaksasVeidsRepo.existsById(id)) samaksasVeidsRepo.deleteById(id);
		else throw new Exception("Nav samaksas veida ar id: "+id);
	}

	
	@Override
	public ArrayList<SamaksasVeids> selectAllSamaksasVeids() throws Exception {
		if(samaksasVeidsRepo.count()==0) throw new Exception("Nav ko atgriezt");
		return (ArrayList<SamaksasVeids>) samaksasVeidsRepo.findAll();
	}
}
