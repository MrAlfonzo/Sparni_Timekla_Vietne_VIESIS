package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import lv.latvijasrokdarbi.model.Kategorija;

public interface IKategorijaService {
	public abstract void createKategorija(Kategorija kategorija);
	
	public abstract Kategorija retrieveKategorijaById(int id) throws Exception;

	public abstract void updateKategorijaById(int id, Kategorija kategorija) throws Exception;
	
	public abstract void deleteKategorijaById(int id) throws Exception;
	
	public abstract ArrayList<Kategorija> selectAllKategorijas() throws Exception;
	
	public abstract ArrayList<Kategorija> filterByNosaukumsOrApraksts(String phrase) throws Exception;
}
