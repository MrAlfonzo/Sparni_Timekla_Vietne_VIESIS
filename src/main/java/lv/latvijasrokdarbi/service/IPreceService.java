package lv.latvijasrokdarbi.service;

import java.util.ArrayList;

import lv.latvijasrokdarbi.model.Prece;

public interface IPreceService {
	
	public abstract void createPrece(Prece prece);
	
	public abstract Prece retrievePreceById(int id) throws Exception;

	public abstract void updatePreceById(int id, Prece prece) throws Exception;
	
	public abstract void deletePreceById(int id) throws Exception;
	
	
	public abstract ArrayList<Prece> selectAllPreces() throws Exception;
	
	public abstract ArrayList<Prece> selectAllPrecesByAtlaideId(int id) throws Exception;
	
	public abstract ArrayList<Prece> selectAllPrecesByKategorijaId(int id) throws Exception;
	
	public abstract ArrayList<Prece> selectAllPrecesCenaLessThan(float cena)throws Exception;
	
	public abstract ArrayList<Prece> filterByDaudzums(int daudzums) throws Exception;
	
	public abstract ArrayList<Prece> filterByNosaukumsOrApraksts(String phrase) throws Exception;
}
