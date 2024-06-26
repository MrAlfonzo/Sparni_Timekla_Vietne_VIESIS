package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Atlaide;
import lv.latvijasrokdarbi.repo.IAtlaideRepo;
import lv.latvijasrokdarbi.service.IAtlaideService;

@Service
public class AtlaideServiceImpl implements IAtlaideService {

	@Autowired
	private IAtlaideRepo atlaideRepo;

	@Override
	public void createAtlaide(Atlaide atlaide) {
		Atlaide existingAtlaide = atlaideRepo.findByNosaukumsAndAtlaidesApmersAndSakumaDatumsLaiksAndBeiguDatumsLaiksAndApraksts(atlaide.getNosaukums(),
				atlaide.getAtlaidesApmers(), atlaide.getSakumaDatumsLaiks(), atlaide.getBeiguDatumsLaiks(),
				atlaide.getApraksts());
		if (existingAtlaide == null) atlaideRepo.save(atlaide);

	}

	@Override
	public Atlaide retrieveAtlaideById(int id) throws Exception {
		if (id < 0)
			throw new Exception("id jābūt pozitīvam");
		if (atlaideRepo.existsById(id))
			return atlaideRepo.findById(id).get();
		else
			throw new Exception("Nav prece ar id: " + id);
	}

	@Override
	public void updateAtlaideById(int id, Atlaide atlaide) throws Exception {
		Atlaide toUpdate = retrieveAtlaideById(id);

		toUpdate.setNosaukums(atlaide.getNosaukums());
		toUpdate.setAtlaidesApmers(atlaide.getAtlaidesApmers());
		toUpdate.setSakumaDatumsLaiks(atlaide.getSakumaDatumsLaiks());
		toUpdate.setBeiguDatumsLaiks(atlaide.getBeiguDatumsLaiks());
		toUpdate.setApraksts(atlaide.getApraksts());

		atlaideRepo.save(toUpdate);

	}

	@Override
	public void deleteAtlaideById(int id) throws Exception {
		atlaideRepo.delete(retrieveAtlaideById(id));

	}

	@Override
	public ArrayList<Atlaide> selectAllAtlaides() throws Exception {
		if (atlaideRepo.count() == 0)
			throw new Exception("preceRepo ir tukša");
		return (ArrayList<Atlaide>) atlaideRepo.findAll();
	}

	@Override
	public ArrayList<Atlaide> filterByNosaukumsOrApraksts(String phrase) throws Exception {
		if (phrase == null)
			throw new Exception("frāze ir null");
		if (atlaideRepo.count() == 0)
			throw new Exception("atlaideRepo ir tukša");
		ArrayList<Atlaide> filteredAtlaide = atlaideRepo
				.findByNosaukumsIgnoreCaseContainingOrAprakstsIgnoreCaseContaining(phrase, phrase);
		return filteredAtlaide;
	}

}
