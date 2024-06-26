package lv.latvijasrokdarbi.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import lv.latvijasrokdarbi.model.Kategorija;
import lv.latvijasrokdarbi.service.IKategorijaService;

@Service
public class KategorijaServiceImpl implements IKategorijaService{

	@Override
	public void createKategorija(Kategorija kategorija) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Kategorija retrieveKategorijaById(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateKategorijaById(int id, Kategorija kategorija) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteKategorijaById(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Kategorija> selectAllKategorijas() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Kategorija> filterByNosaukumsOrApraksts(String phrase) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
