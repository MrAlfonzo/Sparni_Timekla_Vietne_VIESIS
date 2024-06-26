package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Prece;
import lv.latvijasrokdarbi.service.IPreceService;

@Service
public class PreceServiceImpl implements IPreceService{

	@Override
	public void createPrece(Prece prece) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Prece retrievePreceById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePreceById(int id, Prece prece) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePreceById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Prece> selectAllPreces() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prece> selectAllPrecesByAtlaideId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prece> selectAllPrecesByKategorijaId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prece> selectAllPrecesPriceLessThan(float price) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prece> filterByQuantity(int threshold) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Prece> filterByNosaukumsOrApraksts(String phrase) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
